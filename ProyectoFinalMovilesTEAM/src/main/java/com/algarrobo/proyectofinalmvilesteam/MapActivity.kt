package com.algarrobo.proyectofinalmvilesteam

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class MapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)


                val btnEnviar: Button = findViewById(R.id.btnElegir)
                val etDistrito: EditText = findViewById(R.id.etDistrito)

                btnEnviar.setOnClickListener {
                    val distrito = etDistrito.text.toString()

                    val intent = Intent()
                    intent.putExtra("DISTRICT", distrito)
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }


    }