package babble.service;

import java.util.List;

import babble.dto.LikeDto;
import babble.dto.UserDto;

public interface LikeService {

	List<LikeDto> getLikes(Long postId);

	void like(Long postId, UserDto userDto);

	void unlike(Long postId, Long userId);

}
