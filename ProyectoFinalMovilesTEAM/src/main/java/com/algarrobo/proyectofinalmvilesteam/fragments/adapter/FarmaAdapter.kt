package com.algarrobo.proyectofinalmvilesteam.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.R
import com.algarrobo.proyectofinalmvilesteam.models.FarmaModel
import com.squareup.picasso.Picasso

class  FarmaAdapter(private var lstFarm: List<FarmaModel>): RecyclerView.Adapter<FarmaAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreF)
        val ivFarmacia: ImageView = itemView.findViewById(R.id.ivFarmacia)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_farm,parent,false))
    }

    override fun getItemCount(): Int {
        return lstFarm.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemFarm = lstFarm[position]
        holder.tvNombre.text = itemFarm.nombre
        Picasso.get().load(itemFarm.imageUrl).into(holder.ivFarmacia)
    }
}
