package babble.service;

import java.util.List;

import babble.dto.BabbleDto;
import babble.dto.UserDto;

public interface BabbleService {

	List<BabbleDto> getBabbles();

	List<BabbleDto> getBabblesWithId(Long id) throws Exception;

	List<BabbleDto> getBabblesWithTag(String tag);

	BabbleDto getBabble(Long id) throws Exception;

	void deleteBabble(Long babbleId, Long userId);

	BabbleDto insertRebabble(BabbleDto babbleDto, UserDto userDto) throws Exception;

}
