package babble.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import babble.dto.UserDto;
import babble.entity.User;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User toEntity(UserDto userDto);

	UserDto toDto(User user);
}
