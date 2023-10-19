package com.example.clinicafieb.controller;

import android.content.Context;


import com.example.clinicafieb.api.ConexaoSqlServer;
import com.example.clinicafieb.model.LoginModel;
import com.example.clinicafieb.model.UsuarioModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginController {


    public static LoginModel validarLogin(Context context, String cpf, String senha) {

        try {

            PreparedStatement pst = ConexaoSqlServer.conectar(context).prepareStatement(
                    "SELECT Usu_CPF,Usu_SENHA FROM Usuario WHERE Usu_CPF=? AND Usu_SENHA=?");

            //Os números abaixo são os indices da ordem dos campos da tabela
            //Deve seguir a ordem
            pst.setString(1, cpf);
            pst.setString(2, senha);

            ResultSet res = pst.executeQuery();
//SELECT Usu_EMAIL,Usu_SENHA FROM Usuario WHERE Usu_EMAIL=? AND Usu_SENHA=?
            while (res.next()) {

                LoginModel loginModel = new LoginModel();

                loginModel.setEmail(res.getString(1));
                loginModel.setSenha(res.getString(2));
                return loginModel;
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

}
