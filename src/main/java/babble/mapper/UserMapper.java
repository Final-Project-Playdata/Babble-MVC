package babble.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import babble.dto.UserDto;
import babble.entity.User;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	
	User toEntity(UserDto userDto);

	UserDto toDto(User user);
	
	List<UserDto> toDtoList(List<User> userList);
	
	List<User> toEntityList(List<UserDto> userDtoList);
	
}
