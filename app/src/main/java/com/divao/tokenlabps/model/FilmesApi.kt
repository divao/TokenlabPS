package com.divao.tokenlabps.model

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmesApi {

    @GET("movies")
    fun getFilmes(): Single<List<Filme>>


    @GET("movies/{idFilme}")
    fun getUnicoFilme(@Path("idFilme") idFilme: String): Single<UnicoFilme>

}