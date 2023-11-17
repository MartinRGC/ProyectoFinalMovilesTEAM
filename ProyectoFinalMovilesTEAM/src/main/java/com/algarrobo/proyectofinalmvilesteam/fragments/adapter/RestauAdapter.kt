package com.algarrobo.proyectofinalmvilesteam.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.R
import com.algarrobo.proyectofinalmvilesteam.models.RestauranteModel
import com.squareup.picasso.Picasso

class RestauAdapter(private var lstRestau: List<RestauranteModel>): RecyclerView.Adapter<RestauAdapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView), View.OnClickListener
    {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val ivRestaurante: ImageView = itemView.findViewById(R.id.ivRestaurante)
        val listener: RecyclerViewEvent = itemView.findViewById(R.id.rvRestaurante)
        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }
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
        Picasso.get().load(itemRestau.imageUrl).into(holder.ivRestaurante)
    }
    interface RecyclerViewEvent{
        fun onItemClick(position: Int)
    }
}