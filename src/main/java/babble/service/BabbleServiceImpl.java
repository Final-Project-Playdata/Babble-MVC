package babble.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<BabbleDto> getBabbles() {
		try {
			logger.info("getBabbles");
			List<BabbleDto> babbleDtos = babbleMapper.toDtoList(babbleDao.findAll());
			babbleDtos.forEach(babble -> {
				babble = checkBabble(babble);
			});

			return babbleDtos;

		} catch (Exception e) {
			logger.error("Error : {}", e);
			throw e;
		}
	}

	public List<BabbleDto> getBabblesWithId(Long id) {
		try {
			logger.info("getBabblesWithId : {}", id);
			List<BabbleDto> babbleDtos = babbleMapper.toDtoList(babbleDao.findByUserId(id));
			babbleDtos.forEach(babble -> {
				babble = checkBabble(babble);
			});

			return babbleDtos;

		} catch (Exception e) {
			logger.error("Error : {}", e);
			throw e;
		}
	}

	public List<BabbleDto> getBabblesWithTag(String tagName) {
		try {
			logger.info("getBabblesWithTag : {}", tagName);
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
			logger.error("Error : {}", e);
			throw e;
		}
	}

	public BabbleDto getBabble(Long id) {
		try {
			logger.info("getBabble : {}", id);
			BabbleDto babbleDto = babbleMapper.toDto(babbleDao.findById(id).get());
			
			return checkBabble(babbleDto);
			
		} catch (Exception e) {
			logger.error("Error : {}", e);
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

				logger.info("insertBabble : {}", babbleDto);
				return checkBabble(babbleMapper.toDto(babbleDao.findById(id).get()));
			} else {
				logger.info("insertBabble fail : {} - {}", babbleDto, userDto);
				throw new Exception("저장실패");
			}
			
		} catch (Exception e) {
			logger.error("Error : {}", e);
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

				logger.info("insertRebabble : {}", babbleDto);
				return checkBabble(babbleMapper.toDto(babbleDao.findById(id).get()));
				
			} else {
				logger.info("insertRebabble fail : {}", babbleDto);
				throw new Exception("저장실패");
			}

		} catch (

		Exception e) {
			logger.error("Error : {}", e);
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
			logger.info("deleteBabble : {} - {}", babbleId, userId);
			
		} catch (Exception e) {
			logger.error("Error : {}", e);
			throw e;
		}
	}

	public BabbleDto checkBabble(BabbleDto babbleDto) {
		Long rebabbleId = babbleDto.getRebabbleId();

		if (rebabbleId != null) {
			babbleDto.setRebabbleUser(babbleDto.getUser());

			Optional<Babble> reBabble = babbleDao.findById(rebabbleId);
			if (reBabble.isPresent()) {
				babbleDto.setUser(userMapper.toDto(reBabble.get().getUser()));
			}

			babbleDto = checkTagLikeComment(babbleDto, rebabbleId);

		} else {
			babbleDto = checkTagLikeComment(babbleDto, babbleDto.getId());
		}

		return babbleDto;
	}

	public BabbleDto checkTagLikeComment(BabbleDto babbleDto, Long id) {
		babbleDto.setTags(tagDao.findTagByBabbleId(id).stream().map(tag -> tag.getName()).collect(Collectors.toList()));

		babbleDto.setLikes(userMapper.toDtoList(
				likeDao.findByBabbleId(id).stream().map(like -> like.getUser()).collect(Collectors.toList())));

		babbleDto.setComments(commentMapper.toDtoList(commentDao.findByBabbleId(id)));
		babbleDto.setRebabbles(babbleMapper.toDtoList(babbleDao.findByRebabbleId(babbleDto.getId())));

		return babbleDto;
	}

}