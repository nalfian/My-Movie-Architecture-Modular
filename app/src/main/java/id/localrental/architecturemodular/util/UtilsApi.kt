package id.localrental.architecturemodular.util

import id.localrental.architecturemodular.BuildConfig
import id.localrental.architecturemodular.data.network.service.MovieServices
import id.localrental.architecturemodular.data.network.RetrofitClient

object UtilsApi {
    val movieServices: MovieServices
        get() = RetrofitClient.invoke(BuildConfig.BASE_URL).create(MovieServices::class.java)
}
