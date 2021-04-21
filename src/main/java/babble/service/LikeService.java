package babble.service;

import babble.dto.UserDto;

public interface LikeService {

	void like(Long postId, UserDto userDto);

	void unlike(Long postId, Long userId);

}
