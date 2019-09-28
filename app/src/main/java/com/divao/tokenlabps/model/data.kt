package com.divao.tokenlabps.model

import com.google.gson.annotations.SerializedName

data class Filme(
        @SerializedName("title")
        val filmeTitulo: String?,
        @SerializedName("poster_url")
        val filmePoster: String?,
        @SerializedName("id")
        val filmeId: String?)

data class UnicoFilme(
        @SerializedName("title")
        val unicoFilmeTitulo: String?,
        @SerializedName("vote_average")
        val unicoFilmeNota: String?,
        @SerializedName("vote_count")
        val unicoFilmeNroVotos: String?,
        @SerializedName("release_date")
        val unicoFilmeDataLancamento: String?,
        @SerializedName("overview")
        val unicoFilmeDescricao: String?,
        @SerializedName("backdrop_url")
        val unicoFilmeImagemCapa: String?,
        val idFilmeChama: String?)
