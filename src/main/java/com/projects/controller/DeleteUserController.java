package com.projects.controller;

import com.projects.def.IDeleteUserService;
import com.projects.service.DeleteUserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/users/delete/*")
public class DeleteUserController extends HttpServlet {

    public DeleteUserService deleteUserService = new DeleteUserService();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)  {
        try {
           deleteUserService.delete(req, resp);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar o usuário:" + e);
        }
    }
}