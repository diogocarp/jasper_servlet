package com.projects.controller;

import com.projects.def.IDeleteUserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteUserController extends HttpServlet {

    public IDeleteUserService iDeleteUserService;

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)  {
        try {
            iDeleteUserService.delete(req, resp);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar o usuário:" + e);
        }
    }
}