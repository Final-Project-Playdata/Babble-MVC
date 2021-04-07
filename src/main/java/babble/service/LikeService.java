package babble.service;

import java.util.List;

import babble.dto.LikeDto;
import babble.dto.UserDto;

public interface LikeService {

	List<LikeDto> getLikeList(Long postId);

	void like(Long postId, UserDto userDto);

	void unlike(Long postId, Long userId);

}
