package id.localrental.architecturemodular.data.network

import id.localrental.architecturemodular.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitClient {

    companion object {
        private var instance: Retrofit? = null
        private val LOCK = Any()

        operator fun invoke(baseUrl: String) = instance ?: synchronized(LOCK) {
            instance ?: buildRetrofit(baseUrl).also { instance = it }
        }

        private fun buildRetrofit(baseUrl: String): Retrofit{
            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("api_key", BuildConfig.KEY)
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(interceptor)
                .build()

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
    }
}
