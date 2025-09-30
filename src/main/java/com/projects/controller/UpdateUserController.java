package com.projects.controller;

import com.projects.def.IUpdateUserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateUserController extends HttpServlet {

    public IUpdateUserService iUpdateUserService;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            iUpdateUserService.update(req, resp);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar o usuário:" + e);
        }
    }
}
