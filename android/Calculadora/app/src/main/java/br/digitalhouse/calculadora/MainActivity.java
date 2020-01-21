package br.digitalhouse.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //variaveis a serem manipuladas
    private EditText inputNumeroUm;
    private EditText inputNumeroDois;
    private Button botaoCalcular;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //metodo que inicia as views com o id
        initViews();

        //setando click no botao para calcular
        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //metodo que executa o calculo ao click do botao
                logicaBotaoCalcular();
            }
        });
    }

    private void logicaBotaoCalcular() {
        //valida se os campos não estão vazios
        if (!inputNumeroUm.getText().toString().isEmpty()
                && !inputNumeroDois.getText().toString().isEmpty()) {

            //converte os dados string para Inteiros
            int numero1 = Integer.parseInt(inputNumeroUm.getText().toString());
            int numero2 = Integer.parseInt(inputNumeroDois.getText().toString());

            //converte os dados para string
            String resultado = String.valueOf(calcular(numero1, numero2));

            //limpa os espacos no edit text
            inputNumeroUm.getText().clear();
            inputNumeroDois.getText().clear();

            //ao realizar a conversão do resultado ele seta na view (TextView)
            textViewResultado.setText(resultado);

        } else {
            //caso algum campo esteja vazio
            inputNumeroUm.setError("Campo inválido!");
            inputNumeroDois.setError("Campo inválido!");
        }
    }

    //metodo que inicia as views
    private void initViews() {
        inputNumeroUm = findViewById(R.id.edit_text_numero_um);
        inputNumeroDois = findViewById(R.id.edit_text_numero_dois);
        botaoCalcular = findViewById(R.id.botao_calcular);
        textViewResultado = findViewById(R.id.texto_resultado);
    }

    //metodo que calcula dois numeros
    private int calcular(int numero1, int numero2) {
        return numero1 + numero2;
    }
}
