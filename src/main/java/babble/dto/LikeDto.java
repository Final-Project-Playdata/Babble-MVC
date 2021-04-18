package babble.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LikeDto {

	private Long id;

	private BabbleDto babble;
	
	private UserDto user;

}
