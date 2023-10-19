package com.example.clinicafieb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.clinicafieb.R;

public class PreCadastroactivity extends AppCompatActivity {

    RadioGroup rgpossuidiabetes, rgpraticaesportes, rgefumante, rghipertensao, rgoutrasdoencas;
    RadioButton rdsimdiabetes, rdnaodiabetes, rdsimesportes, rdnaoesportes, rdsimfumante, rdnaofumante,
            rdsimhipertensao, rdnaohipertensao, rdsimoutrasdoencas, rdnaooutrasdoencas;
    Button btnconcluirprecadastro;
    String simdiabetes,naodiabetes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_cadastroactivity);
        inicializarComponentes();

//            btnconcluirprecadastro.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    rgpossuidiabetes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                        @Override
//                        public void onCheckedChanged(RadioGroup group, int checkedId) {
//                            switch (checkedId){
//                                case R.id.rdsimdiabetes:  extra
//                                    break;
//                                case R.id.rdnaodiabetes:  naodiabetes = "Não Possui diabetes";
//                                    break;
//                            }
//                        }
//                    });
//                }
//            });
    }

    private void inicializarComponentes() {
        rgpossuidiabetes = findViewById(R.id.rgpossuidiabetes);
        rgpraticaesportes = findViewById(R.id.rgpraticaesportes);
        rgefumante = findViewById(R.id.rgfumante);
        rghipertensao = findViewById(R.id.rghipertensao);
        rgoutrasdoencas = findViewById(R.id.rgoutrasdoencas);

        rdsimdiabetes = findViewById(R.id.rdsimdiabetes);
        rdnaodiabetes = findViewById(R.id.rdnaodiabetes);
        rdsimesportes = findViewById(R.id.rdsimesportes);
        rdnaoesportes = findViewById(R.id.rdnaoesportes);
        rdsimfumante = findViewById(R.id.rdsimfumante);
        rdnaofumante = findViewById(R.id.rdnaofumante);
        rdsimhipertensao = findViewById(R.id.rdsimhipertensao);
        rdnaohipertensao = findViewById(R.id.rdnaohipertensao);
        rdsimoutrasdoencas = findViewById(R.id.rdsimoutrasdoencas);
        rdnaooutrasdoencas = findViewById(R.id.rdnaooutrasdoencas);

        btnconcluirprecadastro = findViewById(R.id.btnconcluirprecadastro);
    }

}