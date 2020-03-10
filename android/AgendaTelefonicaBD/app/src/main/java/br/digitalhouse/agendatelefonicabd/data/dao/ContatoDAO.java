package br.digitalhouse.agendatelefonicabd.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.digitalhouse.agendatelefonicabd.model.Contato;

@Dao
public interface ContatoDAO {

    @Insert
    void insereContato(Contato contato);

    @Delete
    void deletaContato(Contato contato);

    @Update()
    void updateContato(Contato contato);

    @Query("SELECT * FROM contatos WHERE nome=:nome")
    Contato getContatoNome(String nome);

    @Query("SELECT telefone FROM contatos WHERE nome=:nome")
    String getContatoTelefone(String nome);

    @Query("SELECT * FROM contatos")
    LiveData<List<Contato>> getTodosContatos();
}
