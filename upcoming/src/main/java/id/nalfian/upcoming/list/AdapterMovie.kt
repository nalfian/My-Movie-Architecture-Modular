package id.nalfian.upcoming.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import id.nalfian.base.base.ItemClickListener
import id.nalfian.base.data.db.entity.Movie
import id.nalfian.upcoming.R

import kotlinx.android.synthetic.main.item_movie.view.*

class AdapterMovie(
    private val context: Context,
    private val movieList: List<Movie>,
    private val listener: ItemClickListener
) :
    RecyclerView.Adapter<AdapterMovie.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        setupView(holder, position)
        holder.itemView.setOnClickListener {
            listener.onClick(position)
        }
    }

    private fun setupView(
        holder: ViewHolder,
        position: Int
    ) {
        holder.tvName.text = movieList[position].title
        holder.tvDesc.text = movieList[position].overview
        holder.tvDate.text = movieList[position].releaseDate
        Glide.with(context)
            .load("http://image.tmdb.org/t/p/w185" + movieList[position].posterPath)
            .into(holder.ivMovie)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.tvName
        val tvDesc: TextView = itemView.tvDesc
        val tvDate: TextView = itemView.tvDate
        val ivMovie: ImageView = itemView.ivMovie
    }

}