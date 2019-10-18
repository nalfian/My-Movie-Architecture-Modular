package id.nalfian.upcoming.list

import id.nalfian.base.data.db.entity.Movie


interface UpcomingView {
    fun onSucces(movies: List<Movie>)
    fun onFailure(message: String)
    fun onFailureConnection()
}