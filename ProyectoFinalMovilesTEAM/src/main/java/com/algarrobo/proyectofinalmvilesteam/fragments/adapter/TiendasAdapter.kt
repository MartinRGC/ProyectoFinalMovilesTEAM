package com.algarrobo.proyectofinalmvilesteam.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.R
import com.algarrobo.proyectofinalmvilesteam.models.TiendasModel
import com.squareup.picasso.Picasso

class TiendasAdapter( private var lstTienda: List<TiendasModel>): RecyclerView.Adapter<TiendasAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreT)
        val ivTienda: ImageView = itemView.findViewById(R.id.ivTiendas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_tiend,parent,false))
    }

    override fun getItemCount(): Int {
        return lstTienda.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemFarm = lstTienda[position]
        holder.tvNombre.text = itemFarm.nombre
        Picasso.get().load(itemFarm.imageUrl).into(holder.ivTienda)
    }
}
