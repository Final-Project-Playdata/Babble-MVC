package babble.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import babble.dto.TagDto;
import babble.entity.Tag;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TagMapper {

	Tag toEntity(TagDto tagDto);

	TagDto toDto(Tag tag);

	List<Tag> toEntityList(List<TagDto> tagDtoList);

	List<TagDto> toDtoList(List<Tag> tagList);
	
}
