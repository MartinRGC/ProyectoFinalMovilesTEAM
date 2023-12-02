package com.algarrobo.proyectofinalmvilesteam.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.R
import com.algarrobo.proyectofinalmvilesteam.models.RestauranteModel
import com.squareup.picasso.Picasso

class RestauAdapter(private var lstRestau: List<RestauranteModel>): RecyclerView.Adapter<RestauAdapter.ViewHolder>() {


    private var clickListener: OnRestauranteClickListener? = null

    interface OnRestauranteClickListener {
        fun onRestauranteClick(restauranteModel: String)
    }

    fun setOnRestauranteClickListener(listener: OnRestauranteClickListener) {
        this.clickListener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombrePago)
        val ivRestaurante: ImageView = itemView.findViewById(R.id.ivProductoR)
        val tvPuntuacion: TextView = itemView.findViewById(R.id.tvPuntuacion)
        val tvTiempo: TextView = itemView.findViewById(R.id.tvTiempo)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_restau, parent, false))
    }

    override fun getItemCount(): Int {
        return lstRestau.size
    }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val itemR = lstRestau[position]
            var IDR = itemR.id
            holder.tvNombre.text = itemR.nombre
            holder.tvPuntuacion.text=itemR.puntuacion
            holder.tvTiempo.text=itemR.tiempo

            Picasso.get().load(itemR.imageUrl).into(holder.ivRestaurante)

            holder.itemView.setOnClickListener {
                clickListener?.onRestauranteClick(IDR) // Pasar solo el ID del restaurante
            }
        }
        }


