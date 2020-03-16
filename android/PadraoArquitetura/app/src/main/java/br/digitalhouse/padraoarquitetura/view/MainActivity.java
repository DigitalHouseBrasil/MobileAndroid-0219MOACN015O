package br.digitalhouse.padraoarquitetura.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;
import br.digitalhouse.padraoarquitetura.R;
import br.digitalhouse.padraoarquitetura.model.Produto;
import br.digitalhouse.padraoarquitetura.view.adapter.ProdutoAdapter;
import br.digitalhouse.padraoarquitetura.view.interfaces.ProdutoListener;
import br.digitalhouse.padraoarquitetura.viewmodel.ProdutoViewModel;

public class MainActivity extends AppCompatActivity implements ProdutoListener {
    private TextInputLayout nomeEdit;
    private TextInputLayout quantidadeEdit;
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

        //Iniciamos o viewModel através do viewModelProviders passando o resposavel pelo viewModel e a classe especifica
        viewModel = ViewModelProviders.of(this).get(ProdutoViewModel.class);

        adapter = new ProdutoAdapter(listaProdutos, this);
        recyclerViewProdutos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewProdutos.setAdapter(adapter);

        //fazemos a chamada do método atraves do viewmodel
        //viewModel.getTodosProdutos();

        //observamos as mudanças da llista de produtos
        // passando o proprietario e a lista com as mmudanças
        viewModel.liveDataProduto.observe(this, produtos -> {

            //atualizamos a lista do adapter
            adapter.atualizaListaProduto(produtos);
        });

        viewModel.recuperaProdutosArquivo();

        botaoAdd.setOnClickListener(view -> {
            verificaCamposInsereProduto();
        });

        botaoDeletar.setOnClickListener(view ->{
            String nome = nomeEdit.getEditText().getText().toString();

            //fazemos a chamada do método atraves do viewmodel
            viewModel.apagaProduto(nome);

            //Limpamos os textInputLayout
            nomeEdit.getEditText().getText().clear();
            quantidadeEdit.getEditText().getText().clear();
        });

        //observamos a exceção caso ocorra exibimos através de um snackBar
        viewModel.erro.observe(this, erroMessagem ->{
            Snackbar.make(nomeEdit, erroMessagem, Snackbar.LENGTH_LONG).show();
        });
    }

    private void verificaCamposInsereProduto() {
        String nome = nomeEdit.getEditText().getText().toString();
        String quantidade = quantidadeEdit.getEditText().getText().toString();

//        if (!nome.isEmpty() && !quantidade.isEmpty()) {
//            int quantidadeEstoque = Integer.parseInt(quantidade);
//            Produto produto = new Produto(nome, quantidadeEstoque);
//
//            //fazemos a chamada do método atraves do viewmodel
//            viewModel.insereProduto(produto, this);
//
//            //Limpamos os textInputLayout
//            nomeEdit.getEditText().getText().clear();
//            quantidadeEdit.getEditText().getText().clear();
//
//        }else{
//            nomeEdit.setError("Preencha os campos");
//            quantidadeEdit.setError("Preencha os campos");
//        }
    }

    private void initViews() {
        nomeEdit = findViewById(R.id.textInputLayoutNomeProduto);
        quantidadeEdit = findViewById(R.id.textInputLayoutQuantidade);
        botaoAdd = findViewById(R.id.floatingActionButtonAdd);
        botaoDeletar = findViewById(R.id.floatingActionButtonDelete);
        recyclerViewProdutos = findViewById(R.id.recyclerViewProdutos);
    }

    @Override
    public void clickProduto(Produto produto) {
        nomeEdit.getEditText().setText(produto.getNome());

        //Converte um int em string
        String quantidadeTexto = String.valueOf(produto.getQuantidade());

        quantidadeEdit.getEditText().setText(quantidadeTexto);
    }
}
