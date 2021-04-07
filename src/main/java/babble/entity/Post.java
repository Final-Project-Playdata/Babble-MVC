package babble.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonBackReference
	@JoinColumn(name = "userId")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	private String fileURL;

	private Long length;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "originPostId")
	private Post originPost;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "retweetPostId")
	private Post retweetPost;

	@JsonManagedReference
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Tag> tagList = new ArrayList<>();

	@JsonManagedReference
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Comment> commentList = new ArrayList<>();

	@JsonManagedReference
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Like> likeList = new ArrayList<>();

	private LocalDateTime regDate;

	private LocalDateTime modDate;
	
}
