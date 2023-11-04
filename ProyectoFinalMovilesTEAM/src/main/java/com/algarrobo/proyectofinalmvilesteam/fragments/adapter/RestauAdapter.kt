package com.algarrobo.proyectofinalmvilesteam.fragments.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.R
import com.algarrobo.proyectofinalmvilesteam.models.RestauranteModel

class RestauAdapter(private var lstRestau: List<RestauranteModel>): RecyclerView.Adapter<RestauAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val ivRest: ImageView = itemView.findViewById(R.id.ivRest)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_restau,parent,false))
    }

    override fun getItemCount(): Int {
        return lstRestau.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemRestau = lstRestau[position]
        holder.tvNombre.text = itemRestau.nombre
        //holder.ivRest.setImageResource(itemRestau.image)
    }
}