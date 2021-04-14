package babble.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import babble.dto.PostDto;
import babble.entity.Post;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

	Post toEntity(PostDto postDto);

	@Mapping(target="user.password", ignore=true)
	PostDto toDto(Post post);

	List<Post> toEntityList(List<PostDto> postDtoList);

	List<PostDto> toDtoList(List<Post> postList);
}
