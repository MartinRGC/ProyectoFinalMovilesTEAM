package com.algarrobo.proyectofinalmvilesteam.fragments.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.DetRestaurante
import com.algarrobo.proyectofinalmvilesteam.R
import com.algarrobo.proyectofinalmvilesteam.models.RestauranteModel
import com.squareup.picasso.Picasso

class RestauAdapter(private var lstRestau: List<RestauranteModel>): RecyclerView.Adapter<RestauAdapter.ViewHolder>() {


    private var clickListener: OnRestauranteClickListener? = null

    interface OnRestauranteClickListener {
        fun onRestauranteClick(restauranteModel: RestauranteModel)
    }

    fun setOnRestauranteClickListener(listener: OnRestauranteClickListener) {
        this.clickListener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val ivRestaurante: ImageView = itemView.findViewById(R.id.ivRestaurante)
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
        holder.tvNombre.text = itemR.nombre
        Picasso.get().load(itemR.imageUrl).into(holder.ivRestaurante)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetRestaurante::class.java)
            intent.putExtra("RESTAURANTE_DETALLE", itemR)
            holder.itemView.context.startActivity(intent)
        }
        }

}
