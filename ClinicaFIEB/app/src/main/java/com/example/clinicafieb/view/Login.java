package com.example.clinicafieb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.clinicafieb.R;
import com.example.clinicafieb.api.Auxiliares;
import com.example.clinicafieb.api.ConexaoSqlServer;
import com.example.clinicafieb.controller.LoginController;
import com.example.clinicafieb.model.LoginModel;

import java.sql.Connection;

public class Login extends AppCompatActivity {
    TextView tvRegistroPaciente,edtLogin,edtSenha;
    Connection conn = ConexaoSqlServer.conectar(getApplication());
    Button btnLogin;

    String usuarioAtual, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicializarConexao();

        tvRegistroPaciente = findViewById(R.id.tvRegistroPaciente);
        btnLogin = findViewById(R.id.btnLogin);

        edtLogin = findViewById(R.id.edtLogin);
        edtSenha = findViewById(R.id.edtSenha);

        tvRegistroPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistroPacientes.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validarCampos()) {
                    usuarioAtual = edtLogin.getText().toString();
                    senha = edtSenha.getText().toString();

                    //Criar objeto para o Login
                    LoginController loginController = new LoginController();//Modelo de dados para o login
                    LoginModel loginModel;//Obtem os usuários
                    loginModel = loginController.validarLogin(getApplicationContext(), usuarioAtual, senha);
                    if (loginModel != null) {
                        Intent intent = new Intent(getApplicationContext(), Index.class);
                        startActivity(intent);
                    } else {
                        Auxiliares.alert(getApplicationContext(), "Usuário ou Senha incorretos!");
                        edtLogin.setText("");
                        edtSenha.setText("");
                        edtLogin.requestFocus();
                    }
                }
            }
        });
    }

    private boolean validarCampos() {
        boolean retorno = true;
        if (edtLogin.getText().toString().isEmpty()) {
            edtLogin.setError("Obrigatório*");
            edtLogin.requestFocus();
            retorno = false;
        } else if (edtSenha.getText().toString().isEmpty()) {
            edtSenha.setError("Obrigatório*");
            edtSenha.requestFocus();
            retorno = false;
        }
        return retorno;
    }


    private void inicializarConexao() {
        try {
            if (conn != null) {
                if (!conn.isClosed()) setTitle("CONEXAO REALIZADA COM SUCESSO");
                else setTitle("A CONEXÃO ESTÁ FECHADA");
            } else {
                setTitle("CONEXAO NULA, NÃO REALIZADA");
            }
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            setTitle("CONEXÃO FALHOU!!!\n" + ex.getMessage());
        }
    }
}