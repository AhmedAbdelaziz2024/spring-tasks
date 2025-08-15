package com.springboot.mapper;

import com.springboot.dto.PostDTO;
import com.springboot.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(source = "account.id", target = "accountId")
    PostDTO toDTO(Post post);

    @Mapping(source = "accountId", target = "account.id")
    Post toEntity(PostDTO dto);
}
