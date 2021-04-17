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
				p = checkPost(p);
			});

			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<PostDto> getPostListWithTag(String tagName) {
		try {
			List<Tag> tagList = tagDao.findByName(tagName);
			List<Post> postList = new ArrayList<>();

			tagList.forEach(t -> {
				postList.add(t.getPost());
			});

			List<PostDto> postDtoList = postMapper.toDtoList(postList);

			postDtoList.forEach(p -> {
				p = checkPost(p);
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
			return checkPost(postDto);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Transactional
	public PostDto insertPost(PostDto postDto, UserDto userDto) throws Exception {
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

				return postMapper.toDto(postDao.findById(id).get());
			} else {
				throw new Exception("저장실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public PostDto updatePost(PostDto postDto, UserDto userDto) throws Exception {
		try {
			Long postId = postDto.getId();
			String uploaderUsername = postDao.findById(postId).get().getUser().getUsername();

			if (uploaderUsername.equals(userDto.getUsername())) {
				if (audioUtil.checkPath(postDto.getFileUrl(), userDto.getUsername())) {
					postDto.setModDate(LocalDateTime.now());
					postDao.save(postMapper.toEntity(postDto));

					List<String> tagNameList = postDto.getTagList();
					List<Tag> findTagDtoList = tagDao.findTagByPostId(postId);

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

					return checkPost(postMapper.toDto(postDao.findById(postId).get()));
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

	@Transactional
	public void deletePost(Long postId, Long userId) {
		try {
			if (postDao.findById(postId).get().getUser().getId() == userId) {
				commentDao.deleteByPostId(postId);
				likeDao.deleteByPostId(postId);
				tagDao.deleteByPostId(postId);
			}
			postDao.deleteByIdAndUserId(postId, userId);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Transactional
	public PostDto insertRetweetPost(PostDto postDto, UserDto userDto) throws Exception {
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

				return checkPost(postMapper.toDto(postDao.findById(id).get()));
			} else {
				throw new Exception("저장실패");
			}

		} catch (

		Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public PostDto checkPost(PostDto postDto) {
		Long retweetPostId = postDto.getRetweetPostId();
		if (retweetPostId != null) {
			postDto.setRetweetUser(postDto.getUser());
			postDto.setUser(userMapper.toDto(postDao.findById(retweetPostId).get().getUser()));
			postDto.setTagList(tagDao.findTagByPostId(retweetPostId).stream().map(tag -> tag.getName())
					.collect(Collectors.toList()));

			postDto.setLikeList(userMapper.toDtoList(likeDao.findByPostId(retweetPostId).stream()
					.map(like -> like.getUser()).collect(Collectors.toList())));

			postDto.setCommentList(commentMapper.toDtoList(commentDao.findByPostId(retweetPostId)));
		} else {
			postDto.setTagList(tagDao.findTagByPostId(postDto.getId()).stream().map(tag -> tag.getName())
					.collect(Collectors.toList()));

			postDto.setLikeList(userMapper.toDtoList(likeDao.findByPostId(postDto.getId()).stream()
					.map(like -> like.getUser()).collect(Collectors.toList())));

			postDto.setCommentList(commentMapper.toDtoList(commentDao.findByPostId(postDto.getId())));
		}
		postDto.setRetweetList(postMapper.toDtoList(postDao.findByRetweetPostId(postDto.getId())));
		return postDto;
	}

}