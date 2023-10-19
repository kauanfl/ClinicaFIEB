package com.example.clinicafieb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.clinicafieb.R;

public class Index extends AppCompatActivity {

    Button btnPreCadastro;
    ListView lvprecadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        inicializarComponentes();

        btnPreCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PreCadastroactivity.class);
                startActivity(intent);
            }
        });
    }

    private void inicializarComponentes(){
        btnPreCadastro = findViewById(R.id.btnPreCadastro);
        lvprecadastro = findViewById(R.id.lvPrecadastro);
    }
}