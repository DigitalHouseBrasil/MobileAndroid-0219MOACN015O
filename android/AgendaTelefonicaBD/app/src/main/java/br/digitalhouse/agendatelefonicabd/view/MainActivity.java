package br.digitalhouse.agendatelefonicabd.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import br.digitalhouse.agendatelefonicabd.R;
import br.digitalhouse.agendatelefonicabd.adapter.ContatoAdapter;
import br.digitalhouse.agendatelefonicabd.data.ContatoDataBase;
import br.digitalhouse.agendatelefonicabd.data.dao.ContatoDAO;
import br.digitalhouse.agendatelefonicabd.interfaces.ContatoListener;
import br.digitalhouse.agendatelefonicabd.model.Contato;

public class MainActivity extends AppCompatActivity implements ContatoListener {
    private TextInputLayout nomeEdit;
    private TextInputLayout telefoneEdit;
    private FloatingActionButton btnAdd;
    private FloatingActionButton btnDelete;
    private RecyclerView recyclerViewContatos;
    private ContatoAdapter adapter;
    private ContatoDAO contatoDAO;
    private List<Contato> listaContatos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ContatoDataBase dataBase = ContatoDataBase.getDatabase(this);
        contatoDAO = dataBase.contatoDAO();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insereBancoDados();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nomeRecuperado = nomeEdit.getEditText().getText().toString();
                deletaBancoDados(nomeRecuperado);
            }
        });

        adapter = new ContatoAdapter(listaContatos, this);
        recyclerViewContatos.setAdapter(adapter);
        recyclerViewContatos.setLayoutManager(new LinearLayoutManager(this));
        pegaDadosBanco(adapter);
    }

    private void deletaBancoDados(final String nomeRecuperado) {
        if (!nomeRecuperado.isEmpty()) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Contato contato = contatoDAO.getContatoNome(nomeRecuperado);

                    if (contato != null) {
                        contatoDAO.deletaContato(contato);
                    }
                }
            }).start();
        }
    }

    private void insereBancoDados() {
        String novoNome = nomeEdit.getEditText().getText().toString();
        String novoTelefone = telefoneEdit.getEditText().getText().toString();

        if (!novoNome.isEmpty() && !novoTelefone.isEmpty()) {

            final Contato contato = new Contato(novoNome, novoTelefone);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    contatoDAO.insereContato(contato);
                }
            }).start();
        }
    }

    private void initViews() {
        nomeEdit = findViewById(R.id.textInputLayoutNome);
        telefoneEdit = findViewById(R.id.textInputLayoutTelefone);
        btnAdd = findViewById(R.id.floatingActionButtonAdd);
        btnDelete = findViewById(R.id.floatingActionButtonDelete);
        recyclerViewContatos = findViewById(R.id.recyclerViewContatos);
    }

    private void pegaDadosBanco(final ContatoAdapter adapter) {

        contatoDAO.getTodosContatos().observe(MainActivity.this, new Observer<List<Contato>>() {
            @Override
            public void onChanged(final List<Contato> novaListaContatos) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.atualizaLista(novaListaContatos);
                    }
                });
            }
        });
    }

    @Override
    public void clickContato(Contato contato) {
        nomeEdit.getEditText().setText(contato.getNome());
        telefoneEdit.getEditText().setText(contato.getTelefone());
    }
}
