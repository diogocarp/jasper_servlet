package com.projects.mapper;

import com.projects.md.models.User;
import com.projects.md.dto.UserRequestDTO;
import com.projects.md.dto.UserResponseDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper()
public interface UserMapper {

    User toEntity(UserRequestDTO dto);

    UserResponseDTO toResponseDto(User user);

    List<UserResponseDTO> toResponseDtoList(List<User> users);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(UserRequestDTO dto, @MappingTarget User entity);
}
