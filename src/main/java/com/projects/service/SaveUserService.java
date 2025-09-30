package com.projects.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.projects.mapper.UserMapper;
import com.projects.md.dto.UserRequestDTO;
import com.projects.md.models.User;
import com.projects.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mapstruct.factory.Mappers;

import java.io.IOException;

public class SaveUserService {

    private final UserRepository userRepository = new UserRepository();
    private final ObjectMapper objectMapper = new ObjectMapper();
    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserRequestDTO dto = objectMapper.readValue(req.getInputStream(), UserRequestDTO.class);

        User user = mapper.toEntity(dto);
        userRepository.save(user);

        resp.getWriter().println(user);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }
}
