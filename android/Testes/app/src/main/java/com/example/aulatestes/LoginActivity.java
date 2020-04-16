package com.example.aulatestes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText email, senha;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.text_email);
        senha = findViewById(R.id.text_senha);
        btnEntrar = findViewById(R.id.btn_login);


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailResultado = email.getText().toString();
                String senhaResultado = senha.getText().toString();

                validaEmailSenha(emailResultado, senhaResultado);
            }
        });
    }

    public boolean validaEmailSenha(String emailResultado, String senhaResultado) {
        if (!emailResultado.isEmpty() && !senhaResultado.isEmpty()){
            startActivity(new Intent(LoginActivity.this, AulaActivity.class));
            return true;
        }else{
            email.setError("Preencha o campo de email");
            senha.setError("Preencha o campo de senha");
            return false;
        }
    }
}
