package id.nalfian.base.data.network.service

import id.nalfian.base.data.network.response.ResponseMovie
import id.nalfian.base.BuildConfig
import retrofit2.Call
import retrofit2.http.GET

interface MovieServices {

    @GET(BuildConfig.UPCOMING)
    fun getMovieUpcoming(): Call<ResponseMovie>

}