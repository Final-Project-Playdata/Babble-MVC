package babble.service;

import java.util.List;

import org.springframework.stereotype.Service;

import babble.dao.PostRepository;
import babble.dao.TagRepository;
import babble.dto.PostDto;
import babble.dto.TagDto;
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

	public List<TagDto> getTagList(Long postId) {
		try {
			return tagMapper.toDtoList(tagDao.findByPostId(postId));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public void insertTagList(Long postId, List<TagDto> tagDtoList, String password) {
		try {
			PostDto postDto = postMapper.toDto(postDao.findById(postId).get());
			String findPassword = postDto.getUser().getPassword();
			
			tagDtoList.forEach(tagDto -> {
				tagDto.setPost(postDto);
				tagDao.save(tagMapper.toEntity(tagDto));
			});

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public void updateTagList(Long postId, List<TagDto> tagDtoList, String password) {
		try {
			PostDto postDto = postMapper.toDto(postDao.findById(postId).get());
			List<TagDto> findTagDtoList = postDto.getTagList();

			if (findTagDtoList.size() > findTagDtoList.size()) {
				findTagDtoList.forEach(tagDto -> {
					if (!findTagDtoList.contains(tagDto)) {
						tagDto.setPost(postDto);
						tagDao.save(tagMapper.toEntity(tagDto));
					}
				});
			} else {
				findTagDtoList.forEach(tagDto -> {
					if (!findTagDtoList.contains(tagDto)) {
						tagDao.delete(tagMapper.toEntity(tagDto));
					}
				});
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

}
