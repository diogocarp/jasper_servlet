package com.projects.def;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ISaveUserService {
    void save(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
