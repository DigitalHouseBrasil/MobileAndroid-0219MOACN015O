package br.digitalhouse.padraoarquitetura.repository.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import br.digitalhouse.padraoarquitetura.model.Produto;
import io.reactivex.Flowable;

/// A anotação @Dao determina que a interface irá conter os métodos de ação dentro do BD
@Dao
public interface ProdutoDAO {

    /// A anotação @Insert determina que o método fará uma inserção no BD
    @Insert
    void inserirProdutoBd(Produto produto);

    /// A anotação @Delete determina que o método fará um delete no BD
    @Delete
    void apagaProdutoBd(Produto produto);

    /// A anotação @Query determina que o método fará uma consulta
    //Flowable é um observable que suporta uma grande quantidade de dados emitido
    //Método que retorna um Flowable do tipo List<Produto> fazendo um select que retorna todos os dados da  tabela
    @Query("SELECT * from produtos")
    Flowable<List<Produto>> todosOsProdutosBd();

    //Método que retorna um produto especifico a partir de uma consulta usando nome como parametro
    @Query("SELECT * FROM produtos WHERE nome=:nome")
    Produto getProdutoPorNomeBd(String nome);
}
