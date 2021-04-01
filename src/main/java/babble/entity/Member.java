package babble.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Entity(name="member")
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String avatar;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String fullName;
	
	private String bio;
	
	private String password;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date regDate;
	
	@OneToMany(mappedBy="member", fetch=FetchType.LAZY)
	private List<Post> posts;
	
	@OneToMany(mappedBy="member", fetch=FetchType.LAZY)
	private List<Comments> comments;
	
	@OneToMany(mappedBy="member", fetch=FetchType.LAZY)
	private List<Likes> likes;
	
	//무한 참조
//	@OneToMany(mappedBy="following", fetch=FetchType.LAZY)
//	private List<Follow> followings;
//
//	@OneToMany(mappedBy="follower", fetch=FetchType.LAZY)
//	private List<Follow> followers;
}
