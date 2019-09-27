package com.divao.tokenlabps.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.divao.tokenlabps.model.Filme

class ListViewModel: ViewModel() {

    val filmes = MutableLiveData<List<Filme>>()
    val filmeLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchFilmes()
    }

    private fun fetchFilmes() {
        val mockData = listOf(Filme("FilmeA"),
                Filme("FilmeB"),
                Filme("FilmeC"),
                Filme("FilmeD"),
                Filme("FilmeE"),
                Filme("FilmeF"),
                Filme("FilmeG"),
                Filme("FilmeH"),
                Filme("FilmeI"),
                Filme("FilmeJ")
        )

        filmeLoadError.value = false
        loading.value = false
        filmes.value = mockData
    }
}