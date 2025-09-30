package com.projects.service;

import com.projects.def.IDeleteUserService;
import com.projects.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteUserService implements IDeleteUserService {

    private final UserRepository userRepository = new UserRepository();

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.parseLong(req.getPathInfo().substring(1));
        userRepository.delete(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
