package com.projects.service;

import com.projects.mapper.UserMapper;
import com.projects.md.models.User;
import com.projects.md.dto.UserResponseDTO;
import com.projects.repository.UserRepository;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindUserService {

    private final UserRepository userRepository = new UserRepository();

    UserMapper mapper = Mappers.getMapper(UserMapper.class);


    public UserResponseDTO findById(String pathId) {
        Long id = Long.parseLong(pathId);

        User user = Optional.ofNullable(userRepository.findById(id))
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        return mapper.toResponseDto(user);
    }

    public List<UserResponseDTO> findAll() {

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> mapper.toResponseDto(user))
                .collect(Collectors.toList());

    }
}
