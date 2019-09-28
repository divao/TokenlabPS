package com.divao.tokenlabps.view

import android.content.Context
import android.content.Intent
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

class FilmeListAdapter(val context: Context, var filmes: ArrayList<Filme>): RecyclerView.Adapter<FilmeListAdapter.FilmeViewHolder>() {

    fun updateFilmes(novosFilmes: List<Filme>) {
        filmes.clear()
        filmes.addAll(novosFilmes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_filme, parent, false)

        return FilmeViewHolder(view)
    }


    override fun getItemCount() = filmes.size

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        holder.bind(context, filmes[position], position)
    }

    class FilmeViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val imageView = view.imageView
        private val filmeTitulo = view.titulo
        var filmeId: String? = null
        private val progressDrawable = getProgressDrawable(view.context)
        val cardView = view.cardView

        fun bind(context: Context, filme: Filme, position: Int) {
            filmeTitulo.text = filme.filmeTitulo
            imageView.loadImage(filme.filmePoster, progressDrawable)
            filmeId = filme.filmeId

            cardView.setOnClickListener {
                val intent = Intent(context, UnicoFilmeActivity::class.java)

                intent.putExtra("idFilme", filmeId)
                // start the activity
                context.startActivity(intent)
            }

        }
    }
}