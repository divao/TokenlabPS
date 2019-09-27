package com.divao.tokenlabps.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.divao.tokenlabps.R
import com.divao.tokenlabps.model.Filme
import kotlinx.android.synthetic.main.item_filme.view.*

class FilmeListAdapter(var filmes: ArrayList<Filme>): RecyclerView.Adapter<FilmeListAdapter.FilmeViewHolder>() {

    fun updateFilmes(novosFilmes: List<Filme>) {
        filmes.clear()
        filmes.addAll(novosFilmes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FilmeViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_filme, parent, false)
    )

    override fun getItemCount() = filmes.size

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        holder.bind(filmes[position])
    }

    class FilmeViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val filmeTitulo = view.titulo

        fun bind(filme: Filme) {
            filmeTitulo.text = filme.filmeTitulo
        }

    }

}