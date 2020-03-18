package br.digitalhouse.padraoarquitetura.repository.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import br.digitalhouse.padraoarquitetura.model.Produto;

//Antoção @Database que determina que essa classe será reponsavél pela criação e verificação do nosso banco de dados
//Dentro dessa anotação declaramos quais sao as classes modelos que estão anotadas como entidades,
//declaramos também a versão do nosso banco de dados e o exportSchema
@Database(entities = {Produto.class}, version = 2, exportSchema = false)
//A anotação @TypeConverters serve para determinarmos quais sao as classes que serão responsáveis pelos metodos
//de conversão de dados dentro do nosso banco de dados
@TypeConverters(ProdutoConverter.class)
public abstract class ProdutoDataBase extends RoomDatabase {

    public abstract ProdutoDAO produtoDAO();
    private static volatile ProdutoDataBase INSTANCE;

    public static ProdutoDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProdutoDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ProdutoDataBase.class, "produto_bd")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
