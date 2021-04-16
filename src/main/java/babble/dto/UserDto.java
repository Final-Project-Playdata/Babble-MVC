package babble.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

	private String avatar; //프로필 사진
	
	private String background;

	private String username; // email

	private String password;
	
	private String nickname;
	
	private String firstName;

	private String lastName;
	
	private String phoneNumber;
	
	private String gender;
	
	private String bio; //자기소개 audio 파일 url
	
	private String role;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birth;

	private LocalDateTime regDate;

	private List<PostDto> postList = new ArrayList<>();

}
