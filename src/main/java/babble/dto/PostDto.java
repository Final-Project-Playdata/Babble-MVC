package babble.dto;

import java.time.LocalDateTime;
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

	private Long likeCount;

	private PostDto parentPost;

	private PostDto retweetPost;

	private List<TagDto> tagList;

	private List<CommentDto> commentList;

	private List<LikeDto> likeList;

	private LocalDateTime regDate;

	private LocalDateTime modDate;

}
