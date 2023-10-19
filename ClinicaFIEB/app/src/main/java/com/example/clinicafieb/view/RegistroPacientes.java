package com.example.clinicafieb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.clinicafieb.R;
import com.example.clinicafieb.api.Auxiliares;
import com.example.clinicafieb.controller.UsuarioController;
import com.example.clinicafieb.model.UsuarioModel;

public class RegistroPacientes extends AppCompatActivity {

    Button btnCadastrar;
    EditText edtCpf, edtNome, edtSenhaR,edtSenhaRconfirm, edtEmail;
    RadioButton rbFeminino, rbMasculino;


    UsuarioController usuarioController;
    UsuarioModel usuarioModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_pacientes);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        edtCpf = findViewById(R.id.edtCpf);
        edtNome = findViewById(R.id.edtNome);
        edtSenhaR = findViewById(R.id.edtSenhaR);
        edtSenhaRconfirm = findViewById(R.id.edtSenhaRconfirm);
        edtEmail = findViewById(R.id.edtEmail);
        rbFeminino = findViewById(R.id.rbFeminino);
        rbMasculino = findViewById(R.id.rbMasculino);

//        edtNome.setText("NomeTeste");
//        edtCpf.setText("8989898989");
//        edtSenhaR.setText("Senha");
//        edtEmail.setText("MyMail");
//        rbFeminino.setChecked(true);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usuarioModel = new UsuarioModel();
                usuarioController = new UsuarioController();
                String SenhaR,SenhaRconfirm;

                if (!edtCpf.getText().toString().equals("")) {
                    if (Auxiliares.isCPF(edtCpf.getText().toString())){
                    }else {
                        edtCpf.setError("CPF não está validado corretamente!");
                        return;
                    }
                    if (!edtNome.getText().toString().equals("")){
                    }else {
                        edtNome.setError("Não deixe em branco !");
                        Auxiliares.alertCustom(getApplicationContext(), "Dados inválidos !\n Falha no registro");
                        return;
                    }if (!edtEmail.getText().toString().equals("")){
                            if (Auxiliares.validEmail(edtEmail.getText().toString())){
                            }else {
                                edtEmail.setError("Email não está validado corretamente !");
                                return;
                            }
                    }else {
                        edtEmail.setError("Não deixe em branco !");
                        Auxiliares.alertCustom(getApplicationContext(), "Dados inválidos !\n Falha no registro");
                        return;
                    }if (!edtSenhaR.getText().toString().equals("")){

                        SenhaR = edtSenhaR.getText().toString();
                        SenhaRconfirm = edtSenhaRconfirm.getText().toString();

                        if (!SenhaR.equals(SenhaRconfirm)){

                            edtSenhaRconfirm.setError("As senhas não coincidem !");
                            edtSenhaR.setError("As senhas não coincidem !");
                            return;
                        }else {

                        }
                    }else {
                        edtSenhaR.setError("Não deixe em branco !");
                        Auxiliares.alertCustom(getApplicationContext(), "Dados inválidos !\n Falha no registro");
                        return;
                    }


                    usuarioModel.setUsu_CPF(edtCpf.getText().toString());
                    usuarioModel.setUsu_EMAIL(edtEmail.getText().toString());
                    usuarioModel.setUsu_NOME(edtNome.getText().toString());
                    usuarioModel.setUsu_SENHA(edtSenhaR.getText().toString());
                    usuarioModel.setUsu_TIPO("M");

                    int validar = usuarioController.cadastrarUsuario(usuarioModel, getApplicationContext());

                    if (validar > 0) {
                        Auxiliares.alertCustom(getApplicationContext(), "Cadastro realizado com Sucesso!");
                    } else {
                        Auxiliares.alertCustom(getApplicationContext(), "Erro ao Cadastrar");
                    }
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                    finish();


                } else {
                    Auxiliares.alertCustom(getApplicationContext(), "Dados inválidos !\n Falha no registro");
                    edtCpf.requestFocus();
                    edtCpf.setError("Não deixe em branco !");
                }
            }
        });

    }
}