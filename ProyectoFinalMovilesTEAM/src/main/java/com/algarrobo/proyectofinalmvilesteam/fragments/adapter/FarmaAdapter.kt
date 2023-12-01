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

class FarmaAdapter(private var lstFarmacia: List<FarmaModel>) :
    RecyclerView.Adapter<FarmaAdapter.ViewHolder>() {

    private var clickListener: OnFarmaciaClickListener? = null

    interface OnFarmaciaClickListener {
        fun onFarmaciaClick(farmaciaModel: String)
    }

    fun setOnFarmaciaClickListener(listener: OnFarmaciaClickListener) {
        this.clickListener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreF)
        val ivFarmacia: ImageView = itemView.findViewById(R.id.ivFarmacia)
        val tvPuntuacion: TextView = itemView.findViewById(R.id.tvPuntuacionF)
        val tvTiempo: TextView = itemView.findViewById(R.id.tvTiempoF)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_farm, parent, false))
    }

    override fun getItemCount(): Int {
        return lstFarmacia.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemF = lstFarmacia[position]
        var IDF = itemF.id
        holder.tvNombre.text = itemF.nombre
        holder.tvPuntuacion.text=itemF.puntuacion
        holder.tvTiempo.text=itemF.tiempo
        Picasso.get().load(itemF.imageUrl).into(holder.ivFarmacia)

        holder.itemView.setOnClickListener {
            clickListener?.onFarmaciaClick(IDF) // Pasar solo el ID del restaurante
        }
    }
}