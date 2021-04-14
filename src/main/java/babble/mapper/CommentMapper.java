package babble.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import babble.dto.CommentDto;
import babble.entity.Comment;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

	Comment toEntity(CommentDto commentDto);

	@Mapping(target="post", ignore=true)
	CommentDto toDto(Comment comment);
	
	List<Comment> toEntityList(List<CommentDto> commentDtoList);
	
	List<CommentDto> toDtoList(List<Comment> commentList);

}
