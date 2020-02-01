package br.digitalhouse.comunicacaoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    //Atributo do tipo TImer que é uma classe nativa do Java
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //MUDANÇA DA SPLASH PARA A MAIN ACTIVITY POR CLIQUE

//        TextView texto = findViewById(R.id.textoSplash);
//
//        texto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //Iniciando a ação de ir para a prioxima tela passando uma nova intenção
//                startActivity(new Intent(SplashActivity.this, MainActivity.class));
//            }
//        });


        //MUDANÇA DA SPLASH PARA A MAIN ACTIVITY POR TEMPO

        //Método do atributo timer que agenda uma tarefa que ira acontecer por 3s onde
        // após acabar o tempo de 3s irá chamar o método jump que irá para a próxima tela
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jump();
            }
        }, 3000);
    }

    //Método que irá cancelar o time e ir para a próxima activity
    private void jump() {
        timer.cancel();

        //Iniciando a ação de ir para a prioxima tela passando uma nova intenção
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}

