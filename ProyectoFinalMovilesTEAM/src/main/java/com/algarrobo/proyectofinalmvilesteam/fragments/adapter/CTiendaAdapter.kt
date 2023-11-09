package com.algarrobo.proyectofinalmvilesteam.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.R
import com.algarrobo.proyectofinalmvilesteam.models.CTiendasModel

import com.squareup.picasso.Picasso

class CTiendaAdapter( private var lstTiendaC: List<CTiendasModel>): RecyclerView.Adapter<CTiendaAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreTC)
        val ivTienda: ImageView = itemView.findViewById(R.id.ivTiendasC)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_tiendac,parent,false))
    }

    override fun getItemCount(): Int {
        return lstTiendaC.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemTiendC = lstTiendaC[position]
        holder.tvNombre.text = itemTiendC.nombre
        Picasso.get().load(itemTiendC.imageUrl).into(holder.ivTienda)
    }
    }