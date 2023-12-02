package com.algarrobo.proyectofinalmvilesteam

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class PrincipalActivity : AppCompatActivity() {

    private val REQUEST_DISTRICT = 101
    private val tvDistrito: TextView by lazy { findViewById(R.id.tvUbicacion) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
    }

    fun Map(view: View) {
        val intent = Intent(this, MapActivity::class.java)
        startActivityForResult(intent, REQUEST_DISTRICT)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_DISTRICT && resultCode == Activity.RESULT_OK) {
            val distrito = data?.getStringExtra("DISTRICT")

            // Actualizar el TextView con el distrito recibido de la actividad Mapa
            tvDistrito.text = distrito
        }
    }

    fun usuario(view: View){
        startActivity(Intent(this,UserActivity::class.java))
    }

    fun restaurante(view: View){
        startActivity(Intent(this,ListadoRestauActivity::class.java))
    }
    fun farmacia(view: View){
        startActivity(Intent(this,ListadoFarmActivity::class.java))
    }
    fun Tiendas(view: View){
        startActivity(Intent(this,ListadoTiendasActivity::class.java))
    }
    fun TiendasC(view: View){
        startActivity(Intent(this,ListadoTiendaCActivity::class.java))
    }
    fun Veterinaria(view: View){
        startActivity(Intent(this,ListadoVeterinariaActivity::class.java))
    }

}