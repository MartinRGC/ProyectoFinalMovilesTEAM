package com.algarrobo.proyectofinalmvilesteam.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.R
import com.algarrobo.proyectofinalmvilesteam.UserData

class UserAdapter(private var userList: List<UserData>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]

        holder.nombreTextView.text = currentUser.nombre
        holder.apellidosTextView.text = currentUser.apellidos
        holder.correoTextView.text = currentUser.correo
        holder.celularTextView.text = currentUser.celular
        holder.direccionTextView.text = currentUser.direccion
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    fun actualizarLista(nuevaLista: List<UserData>) {
        userList = nuevaLista
        notifyDataSetChanged()
    }
    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.nombreTextView)
        val apellidosTextView: TextView = itemView.findViewById(R.id.apellidosTextView)
        val correoTextView: TextView = itemView.findViewById(R.id.correoTextView)
        val celularTextView: TextView = itemView.findViewById(R.id.celularTextView)
        val direccionTextView: TextView = itemView.findViewById(R.id.direccionTextView)
    }

}
