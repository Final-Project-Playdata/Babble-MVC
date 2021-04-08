package babble.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	private String username; // email

	private String password;

	private String firstName;

	private String lastName;

	private String bio;

	private String role;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birth;

	private LocalDateTime regDate;

	private LocalDateTime modDate;

	@JsonManagedReference
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Post> postList = new ArrayList<>();

	@JsonManagedReference
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Comment> commentList = new ArrayList<>();

	@JsonManagedReference
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Like> likeList = new ArrayList<>();

	public void update(String avatar, String firstName, String lastName, String bio, LocalDate birth) {
		this.avatar = avatar;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bio = bio;
		this.birth = birth;
	}
	
	public void signUp(String username, String password) {
		this.username = username;
		this.password = password;
		this.regDate = LocalDateTime.now();
	}

}
