package id.nalfian.upcoming.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.nalfian.upcoming.detail.DetailActivity
import id.nalfian.base.base.ItemClickListener
import id.nalfian.base.data.db.entity.Movie
import id.nalfian.base.util.Notify
import id.nalfian.upcoming.R
import kotlinx.android.synthetic.main.activity_upcoming.*

class UpcomingActivity : AppCompatActivity(), UpcomingView {

    override fun onSucces(movies: List<Movie>) {
        this.movies.addAll(movies)
        rvMoview.adapter?.notifyDataSetChanged()
    }

    override fun onFailure(message: String) {
       Notify.showOnFailure(rootView, message)
    }

    override fun onFailureConnection() {
        Notify.showOnFailureConnection(rootView, this)
    }


    private var movies: MutableList<Movie> = ArrayList()
    private var presenter: UpcomingPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upcoming)
        initRv()
        initPresenter()
        getMovies()
    }

    private fun getMovies() {
        presenter?.getMovies()
    }

    private fun initRv() {
        val listener = object : ItemClickListener {
            override fun onClick(position: Int) {
                goToDetail(position)
            }
        }

        rvMoview.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            isNestedScrollingEnabled = false
            adapter = AdapterMovie(context, movies, listener)
        }
    }

    private fun goToDetail(position: Int) {
        startActivity(
            Intent(this, DetailActivity::class.java)
            .putExtra("data", movies[position])
        )
    }

    private fun initPresenter() {
        presenter = UpcomingPresenter(this, this)
    }
}
