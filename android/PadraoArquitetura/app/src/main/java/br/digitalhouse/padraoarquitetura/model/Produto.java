
package br.digitalhouse.padraoarquitetura.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

@Entity(tableName = "produtos")
public class Produto {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @Expose
    private Long id;

    @ColumnInfo(name = "nome")
    @Expose
    private String nome;

    @ColumnInfo(name = "quantidade")
    @Expose
    private Long quantidade;

    public Produto(String nome, Long quantidade){
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

}
