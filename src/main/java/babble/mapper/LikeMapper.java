package babble.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import babble.dto.LikeDto;
import babble.entity.Like;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LikeMapper {

	Like toEntity(LikeDto likeDto);

	@Mapping(target="babble", ignore=true)
	LikeDto toDto(Like like);

	List<Like> toEntityList(List<LikeDto> likeDtoList);

	List<LikeDto> toDtoList(List<Like> likeList);
}
