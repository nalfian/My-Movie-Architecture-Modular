package id.localrental.architecturemodular.data.network.service

import id.localrental.architecturemodular.data.network.response.ResponseMovie
import id.localrental.architecturemodular.BuildConfig
import retrofit2.Call
import retrofit2.http.GET

interface MovieServices {

    @GET(BuildConfig.UPCOMING)
    fun getMovieUpcoming(): Call<ResponseMovie>

}