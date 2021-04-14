package babble.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "follow")
public class Follow {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JoinColumn(name = "followingId")
	@ManyToOne(fetch = FetchType.LAZY)
	private User following; //팔로우하는 사람

	@JoinColumn(name = "followerId")
	@ManyToOne(fetch = FetchType.LAZY)
	private User follower; //팔로우받는 사람

	private LocalDateTime regDate;
	
}
