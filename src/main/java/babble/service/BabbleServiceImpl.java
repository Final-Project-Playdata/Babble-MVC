package babble.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import babble.dao.BabbleRepository;
import babble.dao.CommentRepository;
import babble.dao.LikeRepository;
import babble.dao.TagRepository;
import babble.dto.BabbleDto;
import babble.dto.TagDto;
import babble.dto.UserDto;
import babble.entity.Babble;
import babble.entity.Tag;
import babble.exception.UserNotMatchException;
import babble.mapper.BabbleMapper;
import babble.mapper.CommentMapper;
import babble.mapper.TagMapper;
import babble.mapper.UserMapper;
import babble.util.AudioUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BabbleServiceImpl implements BabbleService {

	private final CommentRepository commentDao;
	private final BabbleRepository babbleDao;
	private final LikeRepository likeDao;
	private final TagRepository tagDao;

	private final CommentMapper commentMapper;
	private final BabbleMapper babbleMapper;
	private final UserMapper userMapper;
	private final TagMapper tagMapper;

	private final AudioUtil audioUtil;

	public List<BabbleDto> getBabbles() {
		try {
			List<BabbleDto> babbleDtos = babbleMapper.toDtoList(babbleDao.findAll());
			babbleDtos.forEach(babble -> {
				babble = checkBabble(babble);
			});

			return babbleDtos;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<BabbleDto> getBabblesWithId(Long id) {
		try {
			List<BabbleDto> babbleDtos = babbleMapper.toDtoList(babbleDao.findByUserId(id));
			babbleDtos.forEach(babble -> {
				babble = checkBabble(babble);
			});

			return babbleDtos;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<BabbleDto> getBabblesWithTag(String tagName) {
		try {
			List<Tag> tagList = tagDao.findByName(tagName);
			List<Babble> babbles = new ArrayList<>();

			tagList.forEach(tag -> {
				babbles.add(tag.getBabble());
			});

			List<BabbleDto> babbleDtos = babbleMapper.toDtoList(babbles);

			babbleDtos.forEach(babble -> {
				babble = checkBabble(babble);
			});

			return babbleDtos;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public BabbleDto getBabble(Long id) {
		try {
			BabbleDto babbleDto = babbleMapper.toDto(babbleDao.findById(id).get());
			return checkBabble(babbleDto);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Transactional
	public BabbleDto insertBabble(BabbleDto babbleDto, UserDto userDto) throws Exception {
		try {
			if (audioUtil.checkPath(babbleDto.getFileUrl(), userDto.getUsername())) {
				babbleDto.setRegDate(LocalDateTime.now());
				babbleDto.setUser(userDto);
				Long id = babbleDao.save(babbleMapper.toEntity(babbleDto)).getId();

				babbleDto.setId(id);
				babbleDto.getTags().forEach(tag -> {
					TagDto tagDto = new TagDto();
					tagDto.setName(tag);
					tagDto.setBabble(babbleDto);
					tagDao.save(tagMapper.toEntity(tagDto));
				});

				return checkBabble(babbleMapper.toDto(babbleDao.findById(id).get()));
			} else {
				throw new Exception("저장실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public BabbleDto updateBabble(BabbleDto babbleDto, UserDto userDto) throws Exception {
		try {
			Long babbleId = babbleDto.getId();
			String uploaderUsername = babbleDao.findById(babbleId).get().getUser().getUsername();

			if (uploaderUsername.equals(userDto.getUsername())) {
				if (audioUtil.checkPath(babbleDto.getFileUrl(), userDto.getUsername())) {
					babbleDto.setModDate(LocalDateTime.now());
					babbleDao.save(babbleMapper.toEntity(babbleDto));

					List<String> tagNames = babbleDto.getTags();
					List<Tag> findTagDtos = tagDao.findTagByBabbleId(babbleId);

					tagNames.forEach(tagName -> {
						if (!findTagDtos.contains(tagName)) {
							TagDto tagDto = new TagDto();
							tagDto.setName(tagName);
							tagDto.setBabble(babbleDto);
							tagDao.save(tagMapper.toEntity(tagDto));
						}
					});

					findTagDtos.forEach(tag -> {
						if (!tagNames.contains(tag)) {
							tagDao.delete(tag);
						}
					});

					return checkBabble(babbleMapper.toDto(babbleDao.findById(babbleId).get()));
				} else {
					throw new Exception("저장실패");
				}
			} else {
				throw new UserNotMatchException();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Transactional
	public void deleteBabble(Long babbleId, Long userId) {
		try {
			if (babbleDao.findById(babbleId).get().getUser().getId() == userId) {
				commentDao.deleteByBabbleId(babbleId);
				likeDao.deleteByBabbleId(babbleId);
				tagDao.deleteByBabbleId(babbleId);
			}
			babbleDao.deleteByIdAndUserId(babbleId, userId);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Transactional
	public BabbleDto insertRebabble(BabbleDto babbleDto, UserDto userDto) throws Exception {
		try {
			if (audioUtil.checkPath(babbleDto.getFileUrl(), userDto.getUsername())) {
				babbleDto.setRegDate(LocalDateTime.now());
				babbleDto.setUser(userDto);
				Long id = babbleDao.save(babbleMapper.toEntity(babbleDto)).getId();
				babbleDto.setId(id);

				babbleDto.getTags().forEach(tag -> {
					TagDto tagDto = new TagDto();
					tagDto.setName(tag);
					tagDto.setBabble(babbleDto);
					tagDao.save(tagMapper.toEntity(tagDto));
				});

				return checkBabble(babbleMapper.toDto(babbleDao.findById(id).get()));
			} else {
				throw new Exception("저장실패");
			}

		} catch (

		Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public BabbleDto checkBabble(BabbleDto babbleDto) {
		Long rebabbleId = babbleDto.getRebabbleId();
		
		if (rebabbleId != null) {
			babbleDto.setRebabbleUser(babbleDto.getUser());
			Optional<Babble> babble = babbleDao.findById(rebabbleId);
			
			if(babble.isPresent()) {
				babbleDto.setUser(userMapper.toDto(babble.get().getUser()));
			}
			
			babbleDto.setTags(tagDao.findTagByBabbleId(rebabbleId).stream().map(tag -> tag.getName())
					.collect(Collectors.toList()));

			babbleDto.setLikes(userMapper.toDtoList(likeDao.findByBabbleId(rebabbleId).stream()
					.map(like -> like.getUser()).collect(Collectors.toList())));

			babbleDto.setComments(commentMapper.toDtoList(commentDao.findByBabbleId(rebabbleId)));
			
		} else {
			babbleDto.setTags(tagDao.findTagByBabbleId(babbleDto.getId()).stream().map(tag -> tag.getName())
					.collect(Collectors.toList()));

			babbleDto.setLikes(userMapper.toDtoList(likeDao.findByBabbleId(babbleDto.getId()).stream()
					.map(like -> like.getUser()).collect(Collectors.toList())));

			babbleDto.setComments(commentMapper.toDtoList(commentDao.findByBabbleId(babbleDto.getId())));
		}
		
		babbleDto.setRebabbles(babbleMapper.toDtoList(babbleDao.findByRebabbleId(babbleDto.getId())));
		
		return babbleDto;
	}

}