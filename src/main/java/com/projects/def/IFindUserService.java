package com.projects.def;

import com.projects.md.dto.UserResponseDTO;

import java.util.List;

public interface IFindUserService {
    UserResponseDTO findById(String id);
    List<UserResponseDTO> findAll();
}
