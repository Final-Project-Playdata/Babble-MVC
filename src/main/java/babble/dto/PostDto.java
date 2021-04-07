package babble.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

	private Long id;

	private UserDto user;

	private String fileURL;

	private Long length;

	private PostDto originPost;

	private PostDto retweetPost;

	private List<TagDto> tagList = new ArrayList<>();

	private List<CommentDto> commentList = new ArrayList<>();

	private List<LikeDto> likeList = new ArrayList<>();

	private LocalDateTime regDate;

	private LocalDateTime modDate;

}
