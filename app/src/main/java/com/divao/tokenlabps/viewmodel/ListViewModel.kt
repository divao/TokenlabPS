package com.divao.tokenlabps.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.v7.widget.CardView
import com.divao.tokenlabps.model.Filme
import com.divao.tokenlabps.model.FilmesService
import com.divao.tokenlabps.model.UnicoFilme
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel: ViewModel() {

    private val filmesService = FilmesService()
    private val unicoFilmeService = FilmesService()
    private val disposable = CompositeDisposable()

    val filmes = MutableLiveData<List<Filme>>()
    val filmeLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    val unicoFilme = MutableLiveData<UnicoFilme>()
    val unicoFilmeLoadError = MutableLiveData<Boolean>()
    val unicoFilmeLoading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchFilmes()
    }

    private fun fetchFilmes() {
        loading.value = true
        disposable.add(
                filmesService.getFilmes()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object: DisposableSingleObserver<List<Filme>>() {
                            override fun onSuccess(value: List<Filme>?) {
                                filmes.value = value
                                filmeLoadError.value = false
                                loading.value = false
                            }

                            override fun onError(e: Throwable?) {
                                filmeLoadError.value = true
                                loading.value = false
                            }

                        })
        )

    }

    fun fetchUnicoFilme(idFilme: String) {
        unicoFilmeLoading.value = true
        disposable.add(
                unicoFilmeService.getUnicoFilme(idFilme)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object: DisposableSingleObserver<UnicoFilme>() {
                            override fun onSuccess(value: UnicoFilme?) {
                                unicoFilme.value = value
                                unicoFilmeLoadError.value = false
                                unicoFilmeLoading.value = false
                            }

                            override fun onError(e: Throwable?) {
                                unicoFilmeLoadError.value = true
                                unicoFilmeLoading.value = false
                            }
                        })

        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}