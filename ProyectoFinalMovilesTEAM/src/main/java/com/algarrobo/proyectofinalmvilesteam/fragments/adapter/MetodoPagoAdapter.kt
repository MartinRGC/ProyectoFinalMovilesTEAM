package com.algarrobo.proyectofinalmvilesteam.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.R
import com.algarrobo.proyectofinalmvilesteam.models.MetodoPagosModel

class MetodoPagoAdapter(private val metodoPagos: List<MetodoPagosModel>) :
    RecyclerView.Adapter<MetodoPagoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mpagos, parent, false)
        return ViewHolder(view)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombrePago)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemMP = metodoPagos[position]
        holder.tvNombre.text=itemMP.nombreM
    }

    override fun getItemCount(): Int {
        return metodoPagos.size
    }


    }

