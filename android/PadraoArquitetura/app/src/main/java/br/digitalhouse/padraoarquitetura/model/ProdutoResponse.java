
package br.digitalhouse.padraoarquitetura.model;

import java.util.List;
import com.google.gson.annotations.Expose;

public class ProdutoResponse {
    @Expose
    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
