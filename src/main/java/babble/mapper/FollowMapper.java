package babble.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import babble.dto.FollowDto;
import babble.entity.Follow;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FollowMapper {

	Follow toEntity(FollowDto followDto);

	FollowDto toDto(Follow follow);

	List<Follow> toEntityList(List<FollowDto> followDtoList);

	List<FollowDto> toDtoList(List<Follow> followList);
}
