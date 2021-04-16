package babble.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "member")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String avatar;

	private String background;

	@Column(unique = true)
	private String username; // email

	private String password;

	private String nickname;

	private String firstName;

	private String lastName;

	private String phoneNumber;

	private String gender;

	private String bio;

	private String role;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birth;

	private LocalDateTime regDate;

	private LocalDateTime modDate;

	public void update(String avatar, String firstName, String lastName, String bio, LocalDate birth, String nickname,
			String gender, String phoneNumber, String background) {
		this.avatar = avatar;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bio = bio;
		this.birth = birth;
		this.nickname = nickname;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.background = background;
	}

}
