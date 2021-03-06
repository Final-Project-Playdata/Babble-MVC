package babble.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

	private Long id;

	private BabbleDto babble;

	private UserDto user;

	private String fileUrl;

	private LocalDateTime regDate;

	private LocalDateTime modDate;

}
