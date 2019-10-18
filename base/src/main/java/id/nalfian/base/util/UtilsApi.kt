package id.nalfian.base.util

import id.nalfian.base.BuildConfig
import id.nalfian.base.data.network.service.MovieServices
import id.nalfian.base.data.network.RetrofitClient

object UtilsApi {
    val movieServices: MovieServices
        get() = RetrofitClient.invoke(BuildConfig.BASE_URL).create(MovieServices::class.java)
}
