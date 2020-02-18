package br.digitalhouse.menuscardview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import br.digitalhouse.menuscardview.R;
import br.digitalhouse.menuscardview.interfaces.ContatoListener;
import br.digitalhouse.menuscardview.model.Contato;
import de.hdodenhof.circleimageview.CircleImageView;

public class ContatoRecyclerViewAdapter extends RecyclerView.Adapter<ContatoRecyclerViewAdapter.ViewHolder> {

    //Declaração do atributo de lista de contatos
    private List<Contato> contatos;

    //Declaração do atributo do tipo da interface
    private ContatoListener listener;

    //Construtor especifico da classe ContatoRecyclerViewAdapter e inicialização do atributo
    public ContatoRecyclerViewAdapter(List<Contato> listaContatos, ContatoListener listener){
        this.contatos = listaContatos;
        this.listener = listener;
    }

    //Método responsável por inflar o layout do item
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).
              inflate(R.layout.item_contatos_recycler_view, parent, false);

        return new ViewHolder(view);
    }

    //Método resposavel por gerenciar o conteudo e passar o contado de acordo com a posição da lista
    // para passar para o viewHolder setar as informações na view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Contato contato = contatos.get(position);
        holder.onBind(contato);

        //habilitando o click no item da lista preferenciando ometodo da interface passando o contato como parametro
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.enviaContato(contato);
            }
        });
    }

    //Método que retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return contatos.size();
    }

    //CLASSE VIEWHOLDER
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nomeContato;
        private TextView telefoneContato;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeContato = itemView.findViewById(R.id.text_view_nome);
            telefoneContato = itemView.findViewById(R.id.text_view_telefone);
        }

        public void onBind(Contato contato){
            nomeContato.setText(contato.getNome());
            telefoneContato.setText(contato.getTelefone());
        }
    }
}
