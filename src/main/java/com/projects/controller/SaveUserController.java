package com.projects.controller;

import com.projects.def.ISaveUserService;
import com.projects.service.SaveUserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/users/create")
public class SaveUserController extends HttpServlet {

    public SaveUserService saveUserService = new SaveUserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            saveUserService.save(req, resp);
        }catch (Exception e){
            throw new RuntimeException("Erro ao inserir usuário!");
        }

    }

}
