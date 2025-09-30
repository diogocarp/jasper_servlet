package com.projects.controller;

import com.google.gson.Gson;
import com.projects.service.FindUserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users/find/*")
public class FindUserController extends HttpServlet {

    public FindUserService findUserService = new FindUserService();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("application/json;charset=UTF-8");

        try (PrintWriter out = resp.getWriter()) {
            String pathInfo = req.getPathInfo();

            if (pathInfo == null || pathInfo.equals("/")) {
                String json = gson.toJson(findUserService.findAll());
                out.println(json);
            } else {
                String id = pathInfo.substring(1);
                String json = gson.toJson(findUserService.findById(id));
                out.print(json);
            }
        }
    }
}

