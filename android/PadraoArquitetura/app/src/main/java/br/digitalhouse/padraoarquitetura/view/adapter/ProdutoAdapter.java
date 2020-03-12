package br.digitalhouse.padraoarquitetura.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.digitalhouse.padraoarquitetura.R;
import br.digitalhouse.padraoarquitetura.model.Produto;
import br.digitalhouse.padraoarquitetura.view.interfaces.ProdutoListener;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHolder> {
    private List<Produto> listaProdutos;
    private ProdutoListener listener;

    public ProdutoAdapter(List<Produto> listaContatos, ProdutoListener listener) {
        this.listaProdutos = listaContatos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_produtos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Produto produto = listaProdutos.get(position);
        holder.onBind(produto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.clickProduto(produto);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }

    public void atualizaListaProduto(List<Produto> novaListaProduto){
        this.listaProdutos.clear();
        this.listaProdutos = novaListaProduto;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nome;
        private TextView quantidade;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textViewNomeProduto);
            quantidade = itemView.findViewById(R.id.textViewQuantidadeEstoque);
        }

        public void onBind(Produto produto) {
            nome.setText(produto.getNome());
            quantidade.setText(produto.getQuantidade());
        }
    }
}
