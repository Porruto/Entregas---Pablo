package com.example.practica3

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practica3.data.noticia


class CardAdapter(val context: NoticiaActivity, private val itemList: List<noticia>) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = itemList[position]
            Glide.with(context)
                .load(item.portada)
                .into(holder.img)
        holder.titulo.text = item.titulo
        holder.descripcion.text = item.resumen
        holder.cardView.setOnClickListener{
            context.saveUltimaNoticia(item)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.link))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.imageView)
        val titulo: TextView = itemView.findViewById(R.id.titulo)
        val descripcion: TextView = itemView.findViewById(R.id.descripcion)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }
}