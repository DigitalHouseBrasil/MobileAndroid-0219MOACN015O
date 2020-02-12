package br.digitalhouse.aularevisao.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.digitalhouse.aularevisao.R;
import br.digitalhouse.aularevisao.interfaces.Comunicador;
import br.digitalhouse.aularevisao.model.Praia;
import br.digitalhouse.aularevisao.model.Usuario;

public class HomeActivity extends AppCompatActivity implements Comunicador {
    private TextView mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        replaceFragment(R.id.container2, new BotoesFragment());

        mensagem = findViewById(R.id.textViewMensagem);

        Intent intent = getIntent();

        if (intent != null) {

            Bundle bundle = intent.getExtras();

            Usuario usuario = bundle.getParcelable("USUARIO");

            mensagem.setText(getString(R.string.mensagem_home, usuario.getNome(), usuario.getEmail()));
        }
    }

    @Override
    public void enviarPraia(Praia praia) {
        Fragment fragment = new PraiaFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable("PRAIA", praia);

        fragment.setArguments(bundle);

        replaceFragment(R.id.container1, fragment);

    }

    private void replaceFragment(int container, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().
                replace(container, fragment).commit();
    }
}
