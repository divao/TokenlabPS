package com.divao.tokenlabps.model

import com.google.gson.annotations.SerializedName

data class Filme(
        @SerializedName("title")
        val filmeTitulo: String?,
        @SerializedName("poster_url")
        val filmePoster: String?)