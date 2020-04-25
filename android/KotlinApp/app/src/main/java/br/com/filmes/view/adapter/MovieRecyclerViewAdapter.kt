package br.com.filmes.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.filmes.R
import br.com.filmes.model.MovieResult
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item_recyclerview.view.*

class MovieRecyclerViewAdapter(var movieList: MutableList<MovieResult>, val clickListener: (MovieResult) -> Unit) :
    RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item_recyclerview, parent, false);
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(movieList[position])
        holder.itemView.setOnClickListener {
            clickListener(movieList[position])
        }
    }

    fun updateList(newList: MutableList<MovieResult>) {
        this.movieList.removeAll(movieList)
        this.movieList = newList
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(movie: MovieResult) {
            itemView.movieName.text = movie.title
            Picasso.get().load(movie.cover_url).into(itemView.movieImage)
        }
    }
}