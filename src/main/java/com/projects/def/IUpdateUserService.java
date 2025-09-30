package com.projects.def;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface IUpdateUserService {
    void update(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
