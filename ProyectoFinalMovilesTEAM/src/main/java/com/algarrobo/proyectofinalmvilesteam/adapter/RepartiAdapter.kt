package com.algarrobo.proyectofinalmvilesteam.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.R
import com.algarrobo.proyectofinalmvilesteam.models.LRepartidorModel

class RepartiAdapter(private var repartList: List<LRepartidorModel>) :
    RecyclerView.Adapter<RepartiAdapter.RepartiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepartiViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item_repartidor, parent, false)
        return RepartiViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RepartiViewHolder, position: Int) {
        val currentRepar = repartList[position]

        holder.bind(currentRepar)

        holder.itemView.setOnClickListener {
            // Aquí puedes manejar la acción de clic en un repartidor
            // por ejemplo, mostrar más detalles o realizar otra acción
        }
    }

    override fun getItemCount(): Int {
        return repartList.size
    }

    fun actualizarLista(nuevaLista: List<LRepartidorModel>) {
        repartList = nuevaLista
        notifyDataSetChanged()
    }

    inner class RepartiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreRepartiTV: TextView = itemView.findViewById(R.id.nombreRepartiTV)
        val apellidoRepaTV: TextView = itemView.findViewById(R.id.apellidoRepaTV)
        val ciudadRepaTV: TextView = itemView.findViewById(R.id.ciudadRepaTV)
        val numeroRepaTV: TextView = itemView.findViewById(R.id.numeroRepaTV)
        val correoRepaTV: TextView = itemView.findViewById(R.id.correoRepaTV)

        fun bind(repartidor: LRepartidorModel) {
            // Configurar vistas con datos del repartidor
            nombreRepartiTV.text = repartidor.nombre
            apellidoRepaTV.text = repartidor.apellido
            ciudadRepaTV.text = repartidor.ciudad
            numeroRepaTV.text = repartidor.numero
            correoRepaTV.text = repartidor.correo
        }
    }
}