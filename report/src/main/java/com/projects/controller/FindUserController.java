package com.projects.controller;


import com.projects.def.IFindUserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class FindUserController extends HttpServlet {

    public IFindUserService ifindUserService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("application/json;charset=UTF-8");

        try (PrintWriter out = resp.getWriter()) {

            String pathInfo = req.getPathInfo();

            if (pathInfo == null || pathInfo.equals("/")) {
                out.println(ifindUserService.findById(pathInfo));

            } else {
                out.println(ifindUserService.findAll());

            }
        }
    }
}
