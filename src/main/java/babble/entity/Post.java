package babble.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="post")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@OneToOne(mappedBy="postId")
	private Long id;
	
	@JoinColumn(name="memberId")
	@ManyToOne(fetch=FetchType.LAZY)
	private Member member;
	
	private String fileURL;
	
	private Long length;
	
	private Long likeCount;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parentPostId")
	private Post parentPost;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="retweetPostId")
	private Post retweetPost;
	
	@OneToMany(mappedBy="post", fetch=FetchType.LAZY)
	private List<Tag> tags;
	
	@OneToMany(mappedBy="post", fetch=FetchType.LAZY)
	private List<Comments> comments;
	
	@OneToMany(mappedBy="post", fetch=FetchType.LAZY)
	private List<Likes> likes;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regDate;
}
