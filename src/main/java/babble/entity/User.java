package babble.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "member")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String avatar;

	private String username; //email

	private String password;
	
	private String firstName;

	private String lastName;

	private String fullName;

	private String bio;

	private String role;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birth;

	private LocalDateTime regDate;

	private LocalDateTime modDate;

	@JsonManagedReference
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Post> postList;

	@JsonManagedReference
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Comment> commentList;

	@JsonManagedReference
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Like> likeList;

	public List<String> getRoleList() {
		if (this.role.length() > 0) {
			return Arrays.asList(this.role.split(","));
		}
		return new ArrayList<>();
	}

}
