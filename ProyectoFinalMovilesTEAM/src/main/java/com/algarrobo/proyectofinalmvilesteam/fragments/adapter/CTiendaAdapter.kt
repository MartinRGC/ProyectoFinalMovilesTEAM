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

class CTiendaAdapter(private var lstTiendaC: List<CTiendasModel>) :
    RecyclerView.Adapter<CTiendaAdapter.ViewHolder>() {

    private var clickListener: OnTiendaCClickListener? = null

    interface OnTiendaCClickListener {
        fun onTiendaCClick(tiendaCModel: String)
    }

    fun setOnTiendaCClickListener(listener: OnTiendaCClickListener) {
        this.clickListener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreTC)
        val ivTiendaC: ImageView = itemView.findViewById(R.id.ivTiendasC)
        val tvPuntuacion: TextView = itemView.findViewById(R.id.tvPuntuacionTC)
        val tvTiempo: TextView = itemView.findViewById(R.id.tvTiempoTC)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_tiendac, parent, false))
    }

    override fun getItemCount(): Int {
        return lstTiendaC.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemTC = lstTiendaC[position]
        var IDTC = itemTC.id
        holder.tvNombre.text = itemTC.nombre
        holder.tvPuntuacion.text=itemTC.puntuacion
        holder.tvTiempo.text=itemTC.tiempo
        Picasso.get().load(itemTC.imageUrl).into(holder.ivTiendaC)

        holder.itemView.setOnClickListener {
            clickListener?.onTiendaCClick(IDTC )
        }
    }
}