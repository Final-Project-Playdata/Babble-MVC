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
public class PostDto {

	private Long id;

	private UserDto user;

	private String fileUrl;

	private float duration;

	private Long retweetPostId;
	
	private UserDto retweetUser;

	private List<String> tagList = new ArrayList<>();

	private List<CommentDto> commentList = new ArrayList<>();

	private List<UserDto> likeList = new ArrayList<>();
	
	private List<PostDto> retweetList = new ArrayList<>();
	
	private LocalDateTime regDate;

	private LocalDateTime modDate;

}
