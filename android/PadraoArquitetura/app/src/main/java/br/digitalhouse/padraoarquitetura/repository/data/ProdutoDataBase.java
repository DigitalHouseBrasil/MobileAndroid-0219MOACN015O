package br.digitalhouse.padraoarquitetura.repository.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.digitalhouse.padraoarquitetura.model.Produto;

@Database(entities = {Produto.class}, version = 1, exportSchema = false)
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
