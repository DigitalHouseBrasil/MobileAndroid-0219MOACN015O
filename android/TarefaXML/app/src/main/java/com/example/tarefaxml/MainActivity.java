package com.example.tarefaxml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nomeEdit;
    private EditText emailEdit;
    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeEdit = findViewById(R.id.nome_id);
        emailEdit = findViewById(R.id.email_id);
        botao = findViewById(R.id.btn_id);



        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = nomeEdit.getText().toString();
                String email = emailEdit.getText().toString();
                validarCampos(nome, email);
            }
        });

    }
    
    public void validarCampos(String nome, String email){
        if (nome.isEmpty() || email.isEmpty()){
            Toast.makeText(this, "Por favor preencha os Dados!", Toast.LENGTH_LONG ).show();
        } else {
            Toast.makeText(this, "Os dados estão corretos!", Toast.LENGTH_LONG ).show();
        }
    }
}
