package br.digitalhouse.agendatelefonicabd.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import br.digitalhouse.agendatelefonicabd.data.dao.ContatoDAO;
import br.digitalhouse.agendatelefonicabd.model.Contato;

@Database(entities = {Contato.class}, version = 1, exportSchema = false)
public abstract class ContatoDataBase extends RoomDatabase {
    public abstract ContatoDAO contatoDAO();

    private static volatile ContatoDataBase INSTANCE;

    public static ContatoDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ContatoDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                           ContatoDataBase.class, "agenda_telefonica_bd")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
