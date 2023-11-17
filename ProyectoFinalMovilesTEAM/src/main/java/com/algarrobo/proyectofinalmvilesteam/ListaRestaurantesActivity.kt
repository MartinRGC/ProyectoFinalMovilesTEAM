package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.fragments.adapter.RestauAdapter

class ListaRestaurantesActivity : AppCompatActivity(), RestauAdapter.RecyclerViewEvent{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_restaurantes)

        val rvRest = findViewById<RecyclerView>(R.id.recyclerView)
        rvRest.layoutManager = LinearLayoutManager(this)
    }

    override fun onItemClick(position: Int) {
        startActivity(Intent(this, ProductosRestauActivity::class.java))
    }
}