package com.example.rickmortyapp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rickmortyapp.R;
import com.example.rickmortyapp.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterCharacters extends RecyclerView.Adapter<AdapterCharacters.ViewHolder> {

    private List<Result> resultList;

    public AdapterCharacters(List<Result> resultList) {
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Result result = resultList.get(position);
        holder.bind(result);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public void setUpdate(List<Result> results) {
        if (this.resultList.isEmpty()){
            this.resultList = results;
        }else {
            this.resultList.addAll(results);
        }
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nome;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.txt_card);
            img = itemView.findViewById(R.id.imgCharacter_card);
        }
        public void bind(Result result){
            nome.setText(result.getName());
            Picasso.get().load(result.getImage()).into(img);
        }
    }
}
