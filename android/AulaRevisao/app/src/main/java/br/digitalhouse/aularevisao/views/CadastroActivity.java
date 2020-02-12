package br.digitalhouse.aularevisao.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import br.digitalhouse.aularevisao.R;
import br.digitalhouse.aularevisao.model.Usuario;

public class CadastroActivity extends AppCompatActivity {
    private TextInputLayout textInputLayoutNome;
    private TextInputLayout textInputLayoutEmail;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        initViews();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = textInputLayoutNome.getEditText().getText().toString();
                String email = textInputLayoutEmail.getEditText().getText().toString();

                if (!nome.isEmpty() && !email.isEmpty()){

                    Usuario usuario = new Usuario(nome, email);

                    Intent intent = new Intent(CadastroActivity.this, HomeActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putParcelable("USUARIO", usuario);

                    intent.putExtras(bundle);

                    startActivity(intent);

                }else{
                    textInputLayoutNome.setError("Preencha o campo");
                    textInputLayoutEmail.setError("Preencha o campo");
                }
            }
        });
    }

    private void initViews(){
        textInputLayoutNome = findViewById(R.id.textInputLayoutNome);
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        btnEntrar = findViewById(R.id.btnEntrar);
    }


}
