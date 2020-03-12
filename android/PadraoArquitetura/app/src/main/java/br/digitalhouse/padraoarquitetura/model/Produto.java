package br.digitalhouse.padraoarquitetura.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

//A anotação @Entity determina que a nossa classe será uma tabela
@Entity(tableName = "produtos")
public class Produto {

    //A anotação @PrimaryKey determina que o atributo id é uma chave-primaria da tabela onde seu valor será gerado automaticamente
    @PrimaryKey(autoGenerate = true)
    //A anotação @ColumnInfo determina que o atributo será uma coluna da tabela
    @ColumnInfo(name = "idProduto")
    private int id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "quantidade")
    private int quantidade;

    private List<Produto> produtos;

    public Produto(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
