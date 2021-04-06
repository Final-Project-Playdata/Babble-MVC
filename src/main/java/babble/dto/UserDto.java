package babble.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private Long id;

	private String avatar;

	private String username; // email

	private String password;

	private String firstName;

	private String lastName;

	private String fullName;

	private String bio;

	private String role;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birth;

	private LocalDateTime regDate;

	private LocalDateTime modDate;

	private List<PostDto> postList;

	private List<CommentDto> commentList;

	private List<LikeDto> likeList;

	public List<String> getRoleList() {
		if (this.role.length() > 0) {
			return Arrays.asList(this.role.split(","));
		}
		return new ArrayList<>();
	}

}
