package com.example.clinicafieb.controller;

import android.content.Context;

import com.example.clinicafieb.api.ConexaoSqlServer;
import com.example.clinicafieb.model.UsuarioModel;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class UsuarioController {

    public int cadastrarUsuario(UsuarioModel usuarioModel, Context context) {

        //Se a resposta for 0 não grava

        //Usu_CPF VARCHAR (14),
        //Usu_NOME VARCHAR (20),
        //Usu_SENHA VARCHAR (20),
        //Usu_TIPO CHAR (1),
        //Usu_EMAIL VARCHAR (30),
        //Usu_CODIGO Int PRIMARY KEY
        //CONSTRAINT CK_Usu_Tipo CHECK (Usu_Tipo IN ('M','A', 'P')) ,

        int resposta = 0;
        try {
            PreparedStatement pst = ConexaoSqlServer.conectar(context).prepareStatement(
                    "INSERT INTO Usuario(Usu_CPF,Usu_NOME,Usu_SENHA,Usu_TIPO,Usu_EMAIL) " +
                            "values (?,?,?,?,?)"
            );
            pst.setString(1, usuarioModel.getUsu_CPF());
            pst.setString(2, usuarioModel.getUsu_NOME());
            pst.setString(3, usuarioModel.getUsu_SENHA());
            pst.setString(5, usuarioModel.getUsu_EMAIL());
            pst.setString(4, usuarioModel.getUsu_TIPO());
            resposta = pst.executeUpdate();
//INSERT INTO tbUsuario(Usu_CPF,Usu_NOME,Usu_SENHA,Usu_TIPO,Usu_EMAIL) values (?,?,?,?,?)
        } catch (Exception e) {
            e.getMessage();
        }

        return resposta;
    }

}
