package br.digitalhouse.agendatelefonicabd.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import br.digitalhouse.agendatelefonicabd.R;
import br.digitalhouse.agendatelefonicabd.interfaces.ContatoListener;
import br.digitalhouse.agendatelefonicabd.model.Contato;

public class ContatoAdapter extends RecyclerView.Adapter<ContatoAdapter.ViewHoler> {

    private List<Contato> listaContatos;
    private ContatoListener listener;

    public ContatoAdapter(List<Contato> listaContatos, ContatoListener listener) {
        this.listaContatos = listaContatos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_contatos, parent, false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        final Contato contato = listaContatos.get(position);
        holder.onBind(contato);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.clickContato(contato);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaContatos.size();
    }

    public void atualizaLista(List<Contato> novaListaContatos) {
        this.listaContatos.clear();
        this.listaContatos = novaListaContatos;
        notifyDataSetChanged();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        private TextView nome;
        private TextView telefone;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textViewNome);
            telefone = itemView.findViewById(R.id.textViewTelefone);
        }

        public void onBind(Contato contato) {
            nome.setText(contato.getNome());
            telefone.setText(contato.getTelefone());
        }
    }
}
