package com.projects.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.def.IUpdateUserService;
import com.projects.mapper.UserMapper;
import com.projects.md.dto.UserRequestDTO;
import com.projects.md.models.User;
import com.projects.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mapstruct.factory.Mappers;

import java.io.IOException;
import java.util.Optional;

public class UpdateUserService implements IUpdateUserService {


    private final UserRepository userRepository = new UserRepository();
    private final ObjectMapper objectMapper = new ObjectMapper();
    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Override
    public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.parseLong(req.getPathInfo().substring(1));
        User existing = Optional.ofNullable(userRepository.findById(id))
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        UserRequestDTO dto = objectMapper.readValue(req.getInputStream(), UserRequestDTO.class);
        mapper.updateEntityFromDto(dto, existing);
        userRepository.update(existing);
        resp.setContentType("application/json");
        objectMapper.writeValue(resp.getOutputStream(), mapper.toResponseDto(existing));
    }
}
