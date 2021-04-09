package babble.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import babble.dao.PostRepository;
import babble.dao.TagRepository;
import babble.dto.PostDto;
import babble.dto.TagDto;
import babble.dto.UserDto;
import babble.exception.UserNotMatchException;
import babble.mapper.PostMapper;
import babble.mapper.TagMapper;
import babble.util.AudioUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

	private final PostRepository postDao;

	private final TagRepository tagDao;

	private final PostMapper postMapper;

	private final TagMapper tagMapper;

	private final AudioUtil audioUtil;

	private final ObjectMapper objectMapper;

	public List<PostDto> getPostList() {
		try {
			return postMapper.toDtoList(postDao.findAll());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<PostDto> getPostListWithTag(String tag) {
		try {
			List<TagDto> tagDtoList = tagMapper.toDtoList(tagDao.findByName(tag));
			List<PostDto> postDtoList = new ArrayList<>();

			tagDtoList.forEach(t -> {
				postDtoList.add(t.getPost());
			});

			return postDtoList;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public PostDto getPost(Long id) {
		try {
			return postMapper.toDto(postDao.findById(id).get());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void insertPost(MultipartFile file, String post, UserDto userDto) throws Exception {
		try {
			PostDto postDto = objectMapper.readValue(post, PostDto.class);
			String fileUrl = audioUtil.saveAudioFile(file, userDto.getUsername());
			float duration = audioUtil.getDuration(file);

			postDto.setFileUrl(fileUrl);
			postDto.setDuration(duration);
			postDto.setRegDate(LocalDateTime.now());
			postDto.setUser(userDto);
			postDao.save(postMapper.toEntity(postDto));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updatePost(MultipartFile file, String post, UserDto userDto) throws Exception {
		try {
			PostDto postDto = objectMapper.readValue(post, PostDto.class);
			
			Long uploaderId = postDto.getId();
			String uploaderUsername = postDao.findById(uploaderId).get().getUser().getUsername();

			if (uploaderUsername.equals(userDto.getUsername())) {
				String fileUrl = audioUtil.saveAudioFile(file, userDto.getUsername());
				float duration = audioUtil.getDuration(file);
				
				postDto.setFileUrl(fileUrl);
				postDto.setDuration(duration);
				postDto.setModDate(LocalDateTime.now());
				postDao.save(postMapper.toEntity(postDto));

			} else {
				throw new UserNotMatchException();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void deletePost(Long postId, Long userId) {
		try {
			postDao.deleteByIdAndUserId(postId, userId);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void insertRetweetPost(MultipartFile file, String post, UserDto userDto) throws Exception {
		try {
			PostDto postDto = objectMapper.readValue(post, PostDto.class);
			PostDto findPostDto = postDto.getRetweetPost();

			PostDto originPostDto = findPostDto.getOriginPost();
			if (originPostDto != null) {
				postDto.setOriginPost(originPostDto);
			} else {
				postDto.setOriginPost(findPostDto);
			}

			String fileUrl = audioUtil.saveAudioFile(file, userDto.getUsername());
			float duration = audioUtil.getDuration(file);
			
			postDto.setFileUrl(fileUrl);
			postDto.setDuration(duration);
			postDto.setRetweetPost(findPostDto);
			postDto.setRegDate(LocalDateTime.now());
			postDto.setUser(userDto);
			postDao.save(postMapper.toEntity(postDto));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
