package com.algarrobo.proyectofinalmvilesteam.fragments.adapter

import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.models.ProductoRestauranteModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.algarrobo.proyectofinalmvilesteam.R
import com.squareup.picasso.Picasso
class ProductoRAdapter(private var productList: List<ProductoRestauranteModel>) :
    RecyclerView.Adapter<ProductoRAdapter.ViewHolder>() {

    private var clickListener: OnProductoRClickListener? = null

    interface OnProductoRClickListener {
        fun onProductoRClick(restauranteModel: String)
    }

    fun setOnProductoRClickListener(listener: OnProductoRClickListener) {
        this.clickListener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProductImage: ImageView = itemView.findViewById(R.id.ivProductoRestaurante)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrecior)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescripcion)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val product = productList[position]
                    val idProducto = product.id ?: return@setOnClickListener // Manejo de posible nulo

                    clickListener?.onProductoRClick(idProducto)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_productosrestaurantes, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        val IDRP = product.id

        holder.tvPrice.text = product.precio ?: "Precio no disponible" // Manejo de posible nulo
        holder.tvDescription.text = product.descripcion ?: "Descripción no disponible" // Manejo de posible nulo

        Picasso.get().load(product.imageUrl).into(holder.ivProductImage)
        holder.itemView.setOnClickListener {
            clickListener?.onProductoRClick(IDRP) // Pasar solo el ID del restaurante
        }
    }
}