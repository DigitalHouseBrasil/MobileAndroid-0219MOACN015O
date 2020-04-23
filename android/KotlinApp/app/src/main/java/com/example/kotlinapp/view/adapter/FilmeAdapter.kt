package com.example.kotlinapp.view.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapp.R
import com.example.kotlinapp.model.Filme
import kotlinx.android.synthetic.main.item_recylcler_view_filme.view.*

class FilmeAdapter(var listaFilmes: MutableList<Filme>) : RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recylcler_view_filme, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listaFilmes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listaFilmes[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(filme: Filme){
            itemView.textViewNome.text = filme.nome
            itemView.textViewTitulo.text = filme.titulo

            val drawable = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                itemView.resources.getDrawable(R.drawable.joker, null)
            } else {
                TODO("VERSION.SDK_INT < LOLLIPOP")
            }

            itemView.imageViewFilme.setImageDrawable(drawable)
        }
    }
}


