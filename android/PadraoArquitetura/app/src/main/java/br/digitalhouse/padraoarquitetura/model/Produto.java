
package br.digitalhouse.padraoarquitetura.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//A anotação @Entity determina que a nossa classe será uma tabela

@Entity(tableName = "produtos")
public class Produto {

    @Expose
    private String descricao;

    @Expose
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idProduto")
    private Long id;

    @Expose
    @SerializedName("name")
    @ColumnInfo(name = "nome")
    private String nome;

    @Expose
    private String preco;

    @Expose
    @ColumnInfo(name = "quantidade")
    private String quantidade;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

}
