package babble.dto;

import java.time.LocalDateTime;

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

	private PostDto post;

	private UserDto user;

	private LocalDateTime regDate;

	private LocalDateTime modDate;

}