package babble.service;

import java.util.List;

import org.springframework.stereotype.Service;

import babble.dao.LikeRepository;
import babble.dao.PostRepository;
import babble.dto.LikeDto;
import babble.dto.PostDto;
import babble.dto.UserDto;
import babble.mapper.LikeMapper;
import babble.mapper.PostMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

	private final LikeRepository likeDao;

	private final PostRepository postDao;

	private final LikeMapper likeMapper;

	private final PostMapper postMapper;

	public List<LikeDto> getLikeList(Long postId) {
		try {
			return likeMapper.toDtoList(likeDao.findByPostId(postId));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void like(Long postId, UserDto userDto) {
		try {
			PostDto postDto = postMapper.toDto(postDao.findById(postId).get());
			LikeDto likeDto = new LikeDto();

			likeDto.setPost(postDto);
			likeDto.setUser(userDto);

			likeDao.save(likeMapper.toEntity(likeDto));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void unlike(Long postId, Long userId) {
		try {
			likeDao.deleteByPostIdAndUserId(postId, userId);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
