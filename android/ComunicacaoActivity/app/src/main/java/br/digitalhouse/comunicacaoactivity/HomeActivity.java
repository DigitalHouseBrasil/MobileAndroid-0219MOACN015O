package br.digitalhouse.comunicacaoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView textoEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textoEmail = findViewById(R.id.textViewEmail);

        //Variavel do tipo Intent que recebe o valor da intent que está chegando da outra tela
        Intent intent = getIntent();

        //Verifica se a intent não é nula
        if (intent != null){

            //Criação da variavel do tipo Bundle que recebe o valor do bundle que está sendo
            //recebido através da intent
            Bundle bundle = intent.getExtras();

            //Variavel que recebe o valor que foi mandado do bundle e recuperado a partir da chave
            String email = bundle.getString("EMAIL");

            //Setando o valor da variavel no textView
            textoEmail.setText(email);

        }
    }
}
