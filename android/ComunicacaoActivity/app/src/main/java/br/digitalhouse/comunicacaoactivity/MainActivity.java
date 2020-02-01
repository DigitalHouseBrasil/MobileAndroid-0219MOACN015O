package br.digitalhouse.comunicacaoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout inputEmail;
    private TextInputLayout inputSenha;
    private FloatingActionButton botaoEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Criação das variaveis que estão recebendo o valor que foi digitado nos
                //TextInputLayout
                String email = inputEmail.getEditText().getText().toString();
                String senha = inputSenha.getEditText().getText().toString();

                //Verifica se as variaveis não estão nulas
                if (!email.isEmpty() && !senha.isEmpty()){

                    //Intenção para ir para a proxima tela dizendo da onde está saindo e para onde vai
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);

                    //Criação do bundle que irá receber o valor que será enviado pela intenção
                    Bundle bundle = new Bundle();
                    //passando o valor para o bundle setando a chave e seu valor
                    bundle.putString("EMAIL", email);

                    //Passando para a intent os valores que serão enviados para a proxima activity
                    intent.putExtras(bundle);

                    //Iniciando a ação de ir para a proxima activity a partir da intenção
                    startActivity(intent);
                }
            }
        });
    }

    private void initViews() {
        inputEmail = findViewById(R.id.textInputLayoutEmail);
        inputSenha = findViewById(R.id.textInputLayoutSenha);
        botaoEnviar = findViewById(R.id.floatingActionButtonEnviar);


    }
}
