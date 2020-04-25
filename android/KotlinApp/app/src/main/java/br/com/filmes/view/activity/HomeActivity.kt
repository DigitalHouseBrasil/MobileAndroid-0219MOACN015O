package br.com.filmes.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import br.com.filmes.R
import br.com.filmes.model.MovieResult
import br.com.filmes.view.adapter.MovieRecyclerViewAdapter
import br.com.filmes.viewmodel.MovieViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_home.*

const val MOVIE = "movie"

class HomeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val list = mutableListOf<MovieResult>()
        val adapter = MovieRecyclerViewAdapter(list) { movie -> clickMovie(movie) }
        val viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        movieList.adapter = adapter
        movieList.layoutManager = GridLayoutManager(this, 2)

        viewModel.getAllMovies()

        viewModel.movieListResult.observe(this, Observer {
            adapter.updateList(it as MutableList<MovieResult>)
        })

        viewModel.loadingResult.observe(this, Observer {
            when {
                it -> {
                    progressBar.visibility = View.VISIBLE
                }
                else -> {
                    progressBar.visibility = View.GONE
                }
            }
        })

        viewModel.errorResult.observe(this, Observer {
            Snackbar.make(movieList, it, Snackbar.LENGTH_SHORT).show()
        })
    }

    private fun clickMovie(movieResult: MovieResult) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra(MOVIE, movieResult)
        startActivity(intent)
        Snackbar.make(movieList, movieResult.title, Snackbar.LENGTH_SHORT).show()
    }
}
