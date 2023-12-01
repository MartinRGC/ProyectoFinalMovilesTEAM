package com.algarrobo.proyectofinalmvilesteam.fragments.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.DetTiendas
import com.algarrobo.proyectofinalmvilesteam.R
import com.algarrobo.proyectofinalmvilesteam.models.TiendasModel
import com.squareup.picasso.Picasso

class TiendasAdapter(private var lstTienda: List<TiendasModel>) :
    RecyclerView.Adapter<TiendasAdapter.ViewHolder>() {

    private var clickListener: OnTiendaClickListener? = null

    interface OnTiendaClickListener {
        fun onTiendaClick(tiendaModel: TiendasModel)
    }

    fun setOnTiendaClickListener(listener: OnTiendaClickListener) {
        this.clickListener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreT)
        val ivTienda: ImageView = itemView.findViewById(R.id.ivTiendas)
        val tvPuntuacion: TextView = itemView.findViewById(R.id.tvPuntuacionT)
        val tvTiempo: TextView = itemView.findViewById(R.id.tvTiempoT)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_tiend, parent, false))
    }

    override fun getItemCount(): Int {
        return lstTienda.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemT = lstTienda[position]
        holder.tvNombre.text = itemT.nombre
        holder.tvPuntuacion.text=itemT.puntuacion
        holder.tvTiempo.text=itemT.tiempo
        Picasso.get().load(itemT.imageUrl).into(holder.ivTienda)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetTiendas::class.java)
            intent.putExtra("TIENDA_DETALLE", itemT)
            holder.itemView.context.startActivity(intent)
        }
    }
}
