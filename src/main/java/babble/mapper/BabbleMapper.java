package babble.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import babble.dto.BabbleDto;
import babble.entity.Babble;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BabbleMapper {

	Babble toEntity(BabbleDto babbleDto);

	@Mapping(target="user.password", ignore=true)
	BabbleDto toDto(Babble babble);

	List<Babble> toEntityList(List<BabbleDto> babbleDtoList);

	List<BabbleDto> toDtoList(List<Babble> babbleList);
}
