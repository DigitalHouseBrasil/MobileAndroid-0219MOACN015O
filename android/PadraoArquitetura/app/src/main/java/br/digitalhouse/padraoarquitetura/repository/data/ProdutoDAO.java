package br.digitalhouse.padraoarquitetura.repository.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import java.util.Observable;

import br.digitalhouse.padraoarquitetura.model.Produto;
import io.reactivex.Flowable;

@Dao
public interface ProdutoDAO {

    @Insert
    void inserirProdutoBd(Produto produto);

    @Delete
    void apagaProdutoBd(Produto produto);

    @Query("SELECT * from produtos")
    Flowable<List<Produto>> todosOsProdutosBd();

    @Query("SELECT * FROM produtos WHERE nome=:nome")
    Produto getProdutoPorNomeBd(String nome);
}
