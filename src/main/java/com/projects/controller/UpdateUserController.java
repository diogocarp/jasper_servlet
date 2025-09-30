package com.projects.controller;

import com.projects.def.IUpdateUserService;
import com.projects.service.UpdateUserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/users/update/*")
public class UpdateUserController extends HttpServlet {

    public UpdateUserService updateUserService = new UpdateUserService();

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            updateUserService.update(req, resp);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar o usuário:" + e);
        }
    }
}
