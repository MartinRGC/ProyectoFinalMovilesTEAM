package com.algarrobo.proyectofinalmvilesteam.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.R
import com.algarrobo.proyectofinalmvilesteam.models.VeterinariaModel
import com.squareup.picasso.Picasso

class VetAdapter( private var lstVeterinaria: List<VeterinariaModel>): RecyclerView.Adapter<VetAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreV)
        val ivVeterinaria: ImageView = itemView.findViewById(R.id.ivVeterinaria)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_vete,parent,false))
    }

    override fun getItemCount(): Int {
        return lstVeterinaria.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemVet = lstVeterinaria[position]
        holder.tvNombre.text = itemVet.nombre
        Picasso.get().load(itemVet.imageUrl).into(holder.ivVeterinaria)
    }
    }