package com.example.animesjson.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animesjson.R;
import com.example.animesjson.model.Anime;

import java.util.List;

public class AdapterAnimes extends RecyclerView.Adapter<AdapterAnimes.ViewzHolder> {
    private List<Anime> animeList;

    public AdapterAnimes(List<Anime> animeList) {
        this.animeList = animeList;
    }

    @NonNull
    @Override
    public ViewzHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewzHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewzHolder holder, int position) {
        final Anime noticia = animeList.get(position);
        holder.onBind(noticia);
    }
    @Override
    public int getItemCount() {
        return animeList.size();
    }

    public void update(List<Anime> noticiasList) {
        this.animeList.clear();
        this.animeList = noticiasList;
        notifyDataSetChanged();
    }

    public class ViewzHolder extends RecyclerView.ViewHolder {

        private TextView textViewTitulo;
        private TextView textViewDescricao;

        public ViewzHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitulo = itemView.findViewById(R.id.textViewNome);
            textViewDescricao = itemView.findViewById(R.id.textViewDesc);
        }
        public void onBind(Anime anime) {
            textViewTitulo.setText(anime.getTitulo());
            textViewDescricao.setText(anime.getEstudio());
        }
    }
}
