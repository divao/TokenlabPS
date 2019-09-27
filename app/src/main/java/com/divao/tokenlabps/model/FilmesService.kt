package com.divao.tokenlabps.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class FilmesService {

    private val BASE_URL = "https://desafio-mobile.nyc3.digitaloceanspaces.com"
    private val api: FilmesApi

    init {
        api = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(FilmesApi::class.java)
    }

    fun getFilmes(): Single<List<Filme>> {
        return api.getFilmes()
    }

}