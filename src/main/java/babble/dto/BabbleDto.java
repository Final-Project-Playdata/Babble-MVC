package babble.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BabbleDto {

	private Long id;

	private UserDto user;

	private String fileUrl;

	private float duration;

	private Long rebabbleId;
	
	private UserDto rebabbleUser;

	private List<String> tags = new ArrayList<>();

	private List<CommentDto> comments = new ArrayList<>();

	private List<UserDto> likes = new ArrayList<>();
	
	private List<BabbleDto> rebabbles = new ArrayList<>();
	
	private LocalDateTime regDate;

	private LocalDateTime modDate;

}
