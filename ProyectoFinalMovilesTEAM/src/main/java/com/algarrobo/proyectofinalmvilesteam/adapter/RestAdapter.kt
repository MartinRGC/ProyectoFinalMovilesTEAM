package com.algarrobo.proyectofinalmvilesteam.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.R
import com.algarrobo.proyectofinalmvilesteam.models.LRestModel

class RestAdapter (private var restaList: List<LRestModel>):
    RecyclerView.Adapter<RestAdapter.RestauViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): RestauViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item_restau, parent, false)
        return RestauViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RestauViewHolder, position: Int) {
        val currentRest = restaList[position]


    }

    override fun getItemCount(): Int {
        return restaList.size
    }
    fun actualizarLista(nuevaLista: List<LRestModel>) {
        restaList = nuevaLista
        notifyDataSetChanged()
    }
    inner class RestauViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nombreRestTV: TextView = itemView.findViewById(R.id.tvDescripcionProd)
        val tipoRestTV: TextView = itemView.findViewById(R.id.tvPreciorProd)
        val telefonoRestTV: TextView = itemView.findViewById(R.id.telefonoRestTV)
        val horarioateRestTV: TextView = itemView.findViewById(R.id.horarioateRestTV)
        val rucRestTV: TextView = itemView.findViewById(R.id.rucRestTV)
    }

}