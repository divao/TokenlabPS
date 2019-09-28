package com.divao.tokenlabps.view

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.divao.tokenlabps.R
import com.divao.tokenlabps.model.Filme
import com.divao.tokenlabps.model.UnicoFilme
import com.divao.tokenlabps.util.getProgressDrawable
import com.divao.tokenlabps.util.loadImage
import kotlinx.android.synthetic.main.item_filme.view.*
import kotlinx.android.synthetic.main.item_unico_filme.view.*

class UnicoFilmeAdapter(var unicoFilme: UnicoFilme?): RecyclerView.Adapter<UnicoFilmeAdapter.UnicoFilmeViewHolder>() {
    override fun getItemCount() = 1

    fun updateUnicoFilme(novoFilme: UnicoFilme) {
        unicoFilme = null
        unicoFilme = novoFilme
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UnicoFilmeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_unico_filme, parent, false)
    )

    override fun onBindViewHolder(holder: UnicoFilmeViewHolder, position: Int) {
        holder.bind(unicoFilme!!)

    }

    class UnicoFilmeViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val unicoImageView = view.unicoImageView
        private val unicoFilmeTitulo = view.unicoFilmeTitulo
        private val progressDrawable = getProgressDrawable(view.context)
        private val unicoFilmeNota = view.unicoFilmeNota
        private val unicoFilmeNroVotos = view.unicoFilmeNroVotos
        private val unicoFilmeDataLancamento = view.unicoFilmeDataLancamento
        private val unicoFilmeDescricao = view.unicoFilmeDescricao

        fun bind(unicoFilme: UnicoFilme) {
            unicoFilmeTitulo.text = unicoFilme.unicoFilmeTitulo
            unicoImageView.loadImage(unicoFilme.unicoFilmeImagemCapa, progressDrawable)
            unicoFilmeNota.text = unicoFilme.unicoFilmeNota
            unicoFilmeNroVotos.text = unicoFilme.unicoFilmeNroVotos
            unicoFilmeDataLancamento.text = unicoFilme.unicoFilmeDataLancamento
            unicoFilmeDescricao.text = unicoFilme.unicoFilmeDescricao
        }

    }

}