package br.com.digitalhouse.firebaseapp.login.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.com.digitalhouse.firebaseapp.R;

import static br.com.digitalhouse.firebaseapp.util.AppUtil.printHashKey;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Método para printar o hash para ser colocado no painel do facebook
        printHashKey(this);
    }
}
