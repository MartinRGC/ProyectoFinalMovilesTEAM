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

class VetAdapter(private var lstVeterinaria: List<VeterinariaModel>) :
    RecyclerView.Adapter<VetAdapter.ViewHolder>() {

    private var clickListener: OnVeterinariaClickListener? = null

    interface OnVeterinariaClickListener {
        fun onVeterinariaClick(veterinariaModel: VeterinariaModel)
    }

    fun setOnVeterinariaClickListener(listener: OnVeterinariaClickListener) {
        this.clickListener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreV)
        val ivVeterinaria: ImageView = itemView.findViewById(R.id.ivVeterinaria)
        val tvPuntuacion: TextView = itemView.findViewById(R.id.tvPuntuacionV)
        val tvTiempo: TextView = itemView.findViewById(R.id.tvTiempoV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_vete, parent, false))
    }

    override fun getItemCount(): Int {
        return lstVeterinaria.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemV = lstVeterinaria[position]
        holder.tvNombre.text = itemV.nombre
        holder.tvPuntuacion.text=itemV.puntuacion
        holder.tvTiempo.text=itemV.tiempo
        Picasso.get().load(itemV.imageUrl).into(holder.ivVeterinaria)

        holder.itemView.setOnClickListener {
            clickListener?.onVeterinariaClick(itemV)
        }
    }
}