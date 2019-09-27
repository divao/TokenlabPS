package com.divao.tokenlabps.model

import io.reactivex.Single
import retrofit2.http.GET

interface FilmesApi {

    @GET("movies")
    fun getFilmes(): Single<List<Filme>>

}