package br.com.filmes.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.filmes.R
import br.com.filmes.model.MovieResult
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        getMovieInfo()
    }

    private fun getMovieInfo() {
        val movie = intent.getSerializableExtra(MOVIE) as MovieResult
        Picasso.get().load(movie.cover_url).into(movieImageDetail)
        movieTitleDetails.text = movie.title
        movieDurationDetail.text = movie.duration
        movieReleaseYearDetail.text = movie.release_year
        movieOverview.text = movie.overview
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {android.R.id.home -> {
                startActivity( Intent(this, HomeActivity::class.java))
                finish()
            }
        }
        return true
    }
}
