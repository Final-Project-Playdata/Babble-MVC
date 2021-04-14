package babble.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import babble.dao.CommentRepository;
import babble.dao.LikeRepository;
import babble.dao.PostRepository;
import babble.dao.TagRepository;
import babble.dto.PostDto;
import babble.dto.TagDto;
import babble.dto.UserDto;
import babble.entity.Post;
import babble.entity.Tag;
import babble.exception.UserNotMatchException;
import babble.mapper.CommentMapper;
import babble.mapper.PostMapper;
import babble.mapper.TagMapper;
import babble.mapper.UserMapper;
import babble.util.AudioUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

	private final PostRepository postDao;

	private final TagRepository tagDao;

	private final LikeRepository likeDao;

	private final CommentRepository commentDao;

	private final PostMapper postMapper;

	private final TagMapper tagMapper;

	private final CommentMapper commentMapper;

	private final UserMapper userMapper;

	private final AudioUtil audioUtil;

	public List<PostDto> getPostList() {
		try {
			List<PostDto> list = postMapper.toDtoList(postDao.findAll());
			list.forEach(p -> {
				p.setTagList(tagDao.findTagByPostId(p.getId()).stream().map(tag -> tag.getName())
						.collect(Collectors.toList()));

				p.setLikeList(userMapper.toDtoList(likeDao.findByPostId(p.getId()).stream().map(like -> like.getUser())
						.collect(Collectors.toList())));

				p.setCommentList(commentMapper.toDtoList(commentDao.findByPostId(p.getId())));
			});

			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<PostDto> getPostListWithTag(String tagName) {
		try {
			List<TagDto> tagDtoList = tagMapper.toDtoList(tagDao.findByName(tagName));
			List<PostDto> postDtoList = new ArrayList<>();

			tagDtoList.forEach(t -> {
				postDtoList.add(t.getPost());
			});

			postDtoList.forEach(p -> {
				p.setTagList(tagDao.findTagByPostId(p.getId()).stream().map(tag -> tag.getName())
						.collect(Collectors.toList()));

				p.setLikeList(userMapper.toDtoList(likeDao.findByPostId(p.getId()).stream().map(like -> like.getUser())
						.collect(Collectors.toList())));

				p.setCommentList(commentMapper.toDtoList(commentDao.findByPostId(p.getId())));
			});

			return postDtoList;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public PostDto getPost(Long id) {
		try {
			PostDto postDto = postMapper.toDto(postDao.findById(id).get());
			postDto.setTagList(tagDao.findTagByPostId(postDto.getId()).stream().map(tag -> tag.getName())
					.collect(Collectors.toList()));

			postDto.setLikeList(userMapper.toDtoList(likeDao.findByPostId(postDto.getId()).stream()
					.map(like -> like.getUser()).collect(Collectors.toList())));

			postDto.setCommentList(commentMapper.toDtoList(commentDao.findByPostId(postDto.getId())));

			return postDto;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Transactional
	public void insertPost(PostDto postDto, UserDto userDto) throws Exception {
		try {
			if (audioUtil.checkPath(postDto.getFileUrl(), userDto.getUsername())) {
				postDto.setRegDate(LocalDateTime.now());
				postDto.setUser(userDto);
				Long id = postDao.save(postMapper.toEntity(postDto)).getId();

				postDto.setId(id);
				postDto.getTagList().forEach(tag -> {
					TagDto tagDto = new TagDto();
					tagDto.setName(tag);
					tagDto.setPost(postDto);
					tagDao.save(tagMapper.toEntity(tagDto));
				});

			} else {
				throw new Exception("저장실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updatePost(PostDto postDto, UserDto userDto) throws Exception {
		try {
			Long uploaderId = postDto.getId();
			String uploaderUsername = postDao.findById(uploaderId).get().getUser().getUsername();

			if (uploaderUsername.equals(userDto.getUsername())) {
				if (audioUtil.checkPath(postDto.getFileUrl(), userDto.getUsername())) {
					postDto.setModDate(LocalDateTime.now());
					postDao.save(postMapper.toEntity(postDto));

					List<String> tagNameList = postDto.getTagList();
					List<Tag> findTagDtoList = tagDao.findTagByPostId(uploaderId);

					tagNameList.forEach(tagName -> {
						if (!findTagDtoList.contains(tagName)) {
							TagDto tagDto = new TagDto();
							tagDto.setName(tagName);
							tagDto.setPost(postDto);
							tagDao.save(tagMapper.toEntity(tagDto));
						}
					});

					findTagDtoList.forEach(tag -> {
						if (!tagNameList.contains(tag)) {
							tagDao.delete(tag);
						}
					});

				} else {
					throw new Exception("저장실패");
				}
			} else {
				throw new UserNotMatchException();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void deletePost(Long postId, Long userId) {
		try {
			postDao.deleteByIdAndUserId(postId, userId);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void insertRetweetPost(PostDto postDto, UserDto userDto) throws Exception {
		try {
			if (audioUtil.checkPath(postDto.getFileUrl(), userDto.getUsername())) {
				Long retweetPostId = postDto.getRetweetPostId();
				Post findPostDto = postDao.findById(retweetPostId).get();

				Long originPostId = findPostDto.getOriginPostId();
				if (originPostId != null) {
					postDto.setOriginPostId(originPostId);
				} else {
					postDto.setOriginPostId(retweetPostId);
				}

				postDto.setRetweetPostId(retweetPostId);
				postDto.setRegDate(LocalDateTime.now());
				postDto.setUser(userDto);
				postDao.save(postMapper.toEntity(postDto));

				postDto.getTagList().forEach(tag -> {
					TagDto tagDto = new TagDto();
					tagDto.setName(tag);
					tagDto.setPost(postDto);
					tagDao.save(tagMapper.toEntity(tagDto));
				});

			} else {
				throw new Exception("저장실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
