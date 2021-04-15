package babble.service;

import org.springframework.stereotype.Service;

import babble.dao.PostRepository;
import babble.dao.TagRepository;
import babble.mapper.PostMapper;
import babble.mapper.TagMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

	private final TagRepository tagDao;

	private final PostRepository postDao;

	private final TagMapper tagMapper;

	private final PostMapper postMapper;

//	public List<TagDto> getTagList(Long postId) {
//		try {
//			return tagMapper.toDtoList(tagDao.findByPostId(postId));
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//	}
//
//	public void insertTagList(Long postId, List<TagDto> tagDtoList, String password) throws Exception {
//		try {
//			Post post = postDao.findById(postId).get();
//			String findPassword = post.getUser().getPassword();
//
//			if (findPassword.equals(password)) {
//				PostDto postDto = postMapper.toDto(post);
//				tagDtoList.forEach(tagDto -> {
//					tagDto.setPost(postDto);
//					tagDao.save(tagMapper.toEntity(tagDto));
//				});
//			} else {
//				throw new UserNotMatchException();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//	}
//
//	public void updateTagList(Long postId, List<TagDto> tagDtoList, String password) throws Exception {
//		try {
//			Post post = postDao.findById(postId).get();
//			String findPassword = post.getUser().getPassword();
//
//			if (findPassword.equals(password)) {
//				PostDto postDto = postMapper.toDto(post);
//				List<TagDto> findTagDtoList = postDto.getTagList();
//
//				if (tagDtoList.size() > findTagDtoList.size()) {
//					tagDtoList.forEach(tagDto -> {
//
//						if (!findTagDtoList.contains(tagDto)) {
//							tagDto.setPost(postDto);
//							tagDao.save(tagMapper.toEntity(tagDto));
//						}
//					});
//				} else {
//					findTagDtoList.forEach(tagDto -> {
//
//						if (!tagDtoList.contains(tagDto)) {
//							tagDao.delete(tagMapper.toEntity(tagDto));
//						}
//					});
//				}
//			} else {
//				throw new UserNotMatchException();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//	}

	public void deleteTagList(Long postId, Long userId) {
		try {
			if (postDao.findById(postId).get().getUser().getId() == userId) {
				tagDao.deleteByPostId(postId);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
