package babble.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import babble.dao.BabbleRepository;
import babble.dao.LikeRepository;
import babble.dto.BabbleDto;
import babble.dto.LikeDto;
import babble.dto.UserDto;
import babble.mapper.BabbleMapper;
import babble.mapper.LikeMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

	private final LikeRepository likeDao;
	private final BabbleRepository postDao;

	private final LikeMapper likeMapper;
	private final BabbleMapper babbleMapper;

	private final BabbleServiceImpl postService;

	public List<LikeDto> getLikes(Long babbleId) {
		try {
			return likeMapper.toDtoList(likeDao.findByBabbleId(babbleId));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<BabbleDto> getLikeBabbles(Long userId) {
		try {
			List<BabbleDto> babbleDtos = babbleMapper.toDtoList(
					likeDao.findByUserId(userId).stream().map(like -> like.getBabble()).collect(Collectors.toList()));

			babbleDtos.forEach(p -> {
				p = postService.checkBabble(p);
			});

			return babbleDtos;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void like(Long babbleId, UserDto userDto) {
		try {
			BabbleDto babbleDto = babbleMapper.toDto(postDao.findById(babbleId).get());
			LikeDto likeDto = new LikeDto();

			likeDto.setBabble(babbleDto);
			likeDto.setUser(userDto);

			likeDao.save(likeMapper.toEntity(likeDto));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Transactional
	public void unlike(Long babbleId, Long userId) {
		try {
			likeDao.deleteByBabbleIdAndUserId(babbleId, userId);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void deleteLikes(Long babbleId, Long userId) {
		try {
			if (postDao.findById(babbleId).get().getUser().getId() == userId) {
				likeDao.deleteByBabbleId(babbleId);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
