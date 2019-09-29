package com.divao.tokenlabps.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.divao.tokenlabps.R
import com.divao.tokenlabps.model.Filme
import com.divao.tokenlabps.model.UnicoFilme
import com.divao.tokenlabps.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_unico_filme.*
import android.support.v4.app.NotificationCompat.getExtras
import android.view.Menu
import android.view.MenuItem


class UnicoFilmeActivity() : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    private val unicoFilmeAdapter = UnicoFilmeAdapter(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unico_filme)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)


        var idFilme = intent.extras.getString("idFilme")

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.fetchUnicoFilme(idFilme)

        unicoFilmeList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = unicoFilmeAdapter
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.unicoFilme.observe(this, Observer {unicoFilme :UnicoFilme? ->
            unicoFilme?.let {
                unicoFilmeList.visibility = View.VISIBLE
                unicoFilmeAdapter.updateUnicoFilme(it) }
        })
        viewModel.unicoFilmeLoadError.observe(this, Observer { isError :Boolean? ->
            isError?.let { unico_list_error.visibility = if(it) View.VISIBLE else View.GONE }
        })
        viewModel.unicoFilmeLoading.observe(this, Observer { isLoading :Boolean? ->
            isLoading?.let {
                unico_loading_view.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    unico_list_error.visibility = View.GONE
                    unicoFilmeList.visibility = View.GONE
                }
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }
}