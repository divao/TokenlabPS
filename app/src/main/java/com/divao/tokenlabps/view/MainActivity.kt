package com.divao.tokenlabps.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.divao.tokenlabps.R
import com.divao.tokenlabps.model.Filme
import com.divao.tokenlabps.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    private val filmesAdapter = FilmeListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        filmesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = filmesAdapter
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.filmes.observe(this, Observer {filmes :List<Filme>? ->
            filmes?.let {
                filmesList.visibility = View.VISIBLE
                filmesAdapter.updateFilmes(it) }
        })
        viewModel.filmeLoadError.observe(this, Observer { isError :Boolean? ->
            isError?.let { list_error.visibility = if(it) View.VISIBLE else View.GONE }
        })
        viewModel.loading.observe(this, Observer { isLoading :Boolean? ->
            isLoading?.let {
                loading_view.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    list_error.visibility = View.GONE
                    filmesList.visibility = View.GONE
                }
            }
        })
    }
}
