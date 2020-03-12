package br.digitalhouse.padraoarquitetura.repository;

import android.content.Context;
import java.util.List;
import br.digitalhouse.padraoarquitetura.model.Produto;
import br.digitalhouse.padraoarquitetura.repository.data.ProdutoDataBase;
import io.reactivex.Flowable;

public class ProdutoRepository {

    //Método na classe repository que irá fazer a chamada ao banco de dados e invocar o método de consulta
    //através do produtoDao declarado na classe ProdutoDataBase
    //Esse método irá retornar o mesmo tipo de dado que o método que está sendo chamado pelo produtoDao
    //para ser usado posteriormente na ViewModel
    public Flowable<List<Produto>> getAllProdutos(Context context){
        //chamada do método de consulta através do banco de dados
        return ProdutoDataBase.getDatabase(context).produtoDAO().todosOsProdutosBd();
    }

    public void insereProduto(Produto produto, Context context){
        ProdutoDataBase.getDatabase(context).produtoDAO().inserirProdutoBd(produto);
    }

    public void apagaProduto(Produto produto, Context context){
        ProdutoDataBase.getDatabase(context).produtoDAO().apagaProdutoBd(produto);
    }

    public Produto retornaProdutoPorNome(String nome, Context context){
        return ProdutoDataBase.getDatabase(context).produtoDAO().getProdutoPorNomeBd(nome);
    }
}
