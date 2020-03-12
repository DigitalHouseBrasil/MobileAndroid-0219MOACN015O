package br.digitalhouse.padraoarquitetura.repository;

import android.content.Context;

import java.util.List;

import br.digitalhouse.padraoarquitetura.model.Produto;
import br.digitalhouse.padraoarquitetura.repository.data.ProdutoDataBase;
import io.reactivex.Flowable;

public class ProdutoRepository {

    public Flowable<List<Produto>> getAllProdutos(Context context){
        return ProdutoDataBase.getDatabase(context).produtoDAO().todosOsProdutosBd();
    }
}
