package com.projects.def;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IDeleteUserService {
    void delete(HttpServletRequest req, HttpServletResponse resp);
}
