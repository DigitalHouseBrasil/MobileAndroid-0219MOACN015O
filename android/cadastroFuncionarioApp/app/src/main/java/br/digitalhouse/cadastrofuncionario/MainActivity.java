package br.digitalhouse.cadastrofuncionario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declaração das variaves do mesmo tipo do componente declarado no xml
    private EditText inputNome;
    private EditText inputEmail;
    private EditText inputTelefone;
    private EditText inputEndereco;
    private Button botaoEnviar;

    //Método que faz tudo acontecer na tela(activity)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fazendo o link entre o componente xml para uma variavél java, assim conseguimos trabbalhar com a logica dos
        //componentes atraves das variaveis que criamos
        inputNome = findViewById(R.id.nome_id);
        inputTelefone = findViewById(R.id.telefone_id);
        inputEmail = findViewById(R.id.email_id);
        inputEndereco = findViewById(R.id.endereco_id);
        botaoEnviar = findViewById(R.id.botao_enviar);

        //Aqui estamos falando para o botão ficar "ouvindo" a ação de click através do método
        //setOnClickListener e quando acontecer o click no método onClick() ele recupera os valores
        // que foram inseridos no editText e chamamos o método que valida os campos
        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Atribuimos os valores que foram inseridos em variaveis
              String nome = inputNome.getText().toString();
              String email = inputEmail.getText().toString();
              String telefone = inputTelefone.getText().toString();
              String endereco = inputEndereco.getText().toString();

              //chamamos o método que valida os campos passando as variaveis como parametro
                validarCampos(nome, email, telefone, endereco);
            }
        });
    }

    //Método que verifica que os campos nao estao vazios se estiver mostra
    //um toast "Preencha todos os campos" senão diz que os dados estão ok
    private void validarCampos(String nome, String telefone, String email, String endereco){
        if (nome.isEmpty() && telefone.isEmpty() && email.isEmpty() && endereco.isEmpty()){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG ).show();
        }else{
            Toast.makeText(this, "Dados estão ok!", Toast.LENGTH_LONG ).show();
        }
    }
}
