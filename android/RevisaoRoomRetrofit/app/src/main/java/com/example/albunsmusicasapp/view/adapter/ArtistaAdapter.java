package com.example.albunsmusicasapp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.albunsmusicasapp.R;
import com.example.albunsmusicasapp.model.Album;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ArtistaAdapter extends RecyclerView.Adapter<ArtistaAdapter.ViewHolder> {
    private List<Album> listaAlbum;

    public ArtistaAdapter(List<Album> listaAlbum) {
        this.listaAlbum = listaAlbum;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_albuns, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = listaAlbum.get(position);
        holder.onBind(album);
    }

    public void limpaListaAdapter(){
        this.listaAlbum.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaAlbum.size();
    }

    public void atualizaLista(List<Album> novaLista){
        if (this.listaAlbum.isEmpty()){
            this.listaAlbum = novaLista;
        }else {
            this.listaAlbum.addAll(novaLista);
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       private ImageView imagem;
       private TextView nomeAlbum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imagem = itemView.findViewById(R.id.imgAbum);
            nomeAlbum = itemView.findViewById(R.id.txtTitulo);
        }

        public void onBind(Album album){
            nomeAlbum.setText(album.getStrAlbum());
            Picasso.get().load(album.getStrAlbumThumb()).into(imagem);
        }
    }
}
