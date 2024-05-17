package eu.tutorials.movieapp.utils

import eu.tutorials.movieapp.domain.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Initializes API Interface

object RetrofitInstance {
    val api: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(Util.Base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}