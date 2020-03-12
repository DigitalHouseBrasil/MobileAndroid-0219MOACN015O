package br.digitalhouse.padraoarquitetura.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import br.digitalhouse.padraoarquitetura.R;
import br.digitalhouse.padraoarquitetura.model.Produto;
import br.digitalhouse.padraoarquitetura.view.adapter.ProdutoAdapter;
import br.digitalhouse.padraoarquitetura.view.interfaces.ProdutoListener;
import br.digitalhouse.padraoarquitetura.viewmodel.ProdutoViewModel;

public class MainActivity extends AppCompatActivity implements ProdutoListener {
    private TextInputLayout nome;
    private TextInputLayout quantidade;
    private FloatingActionButton botaoAdd;
    private FloatingActionButton botaoDeletar;
    private RecyclerView recyclerViewProdutos;
    private ProdutoAdapter adapter;
    private ProdutoViewModel viewModel;
    private List<Produto> listaProdutos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        viewModel = ViewModelProviders.of(this).get(ProdutoViewModel.class);

        adapter = new ProdutoAdapter(listaProdutos, this);
        recyclerViewProdutos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewProdutos.setAdapter(adapter);

        viewModel.getTodosProdutos(this);

        viewModel.liveDataProduto.observe(this, produtos -> {
            adapter.atualizaListaProduto(produtos);
        });
    }

    private void initViews(){
        nome = findViewById(R.id.textInputLayoutNomeProduto);
        quantidade = findViewById(R.id.textInputLayoutQuantidade);
        botaoAdd = findViewById(R.id.floatingActionButtonAdd);
        botaoDeletar = findViewById(R.id.floatingActionButtonDelete);
        recyclerViewProdutos = findViewById(R.id.recyclerViewProdutos);
    }

    @Override
    public void clickProduto(Produto produto) {

    }
}
