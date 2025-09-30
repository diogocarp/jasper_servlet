package com.projects.controller;

import com.projects.def.ISaveUserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SaveUserController extends HttpServlet {
    public ISaveUserService iSaveUserService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            iSaveUserService.save(req, resp);
        }catch (Exception e){
            throw new RuntimeException("Erro ao inserir usuário!");
        }

    }

}
