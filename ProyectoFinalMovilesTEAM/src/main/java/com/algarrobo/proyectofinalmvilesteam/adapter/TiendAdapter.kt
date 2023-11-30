package com.algarrobo.proyectofinalmvilesteam.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.R
import com.algarrobo.proyectofinalmvilesteam.models.LTiendasModel

class TiendAdapter (private var tiendasList: List<LTiendasModel>) :
    RecyclerView.Adapter<TiendAdapter.TiendasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TiendasViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item_tienda, parent, false)
        return TiendasViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TiendasViewHolder, position: Int) {
        val currentTienda = tiendasList[position]

        holder.nombreTextView.text = currentTienda.nombre
        holder.categoriaTextView.text = currentTienda.categoria
        holder.telefonoTextView.text = currentTienda.telefono
        holder.direccionTextView.text = currentTienda.direccion
        holder.horariodeatencionTextView.text = currentTienda.horariodeatencion
    }

    override fun getItemCount(): Int {
        return tiendasList.size
    }

    fun actualizarLista(nuevaLista: List<LTiendasModel>) {
        tiendasList = nuevaLista
        notifyDataSetChanged()
    }

    inner class TiendasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.nombreTextView)
        val categoriaTextView: TextView = itemView.findViewById(R.id.categoriaTextView)
        val telefonoTextView: TextView = itemView.findViewById(R.id.telefonoTextView)
        val direccionTextView: TextView = itemView.findViewById(R.id.direccionTextView)
        val horariodeatencionTextView: TextView = itemView.findViewById(R.id.horariodeatencionTextView)
    }
}