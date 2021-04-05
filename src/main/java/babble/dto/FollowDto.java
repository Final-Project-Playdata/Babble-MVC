package babble.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FollowDto {

	private Long id;

	private UserDto following;

	private UserDto follower;

	private LocalDateTime regDate;

	private LocalDateTime modDate;
	
}
