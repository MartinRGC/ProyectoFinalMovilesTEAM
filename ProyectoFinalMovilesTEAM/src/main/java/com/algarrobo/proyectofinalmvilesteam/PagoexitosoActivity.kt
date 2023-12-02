package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class PagoexitosoActivity: AppCompatActivity() {
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagoexitoso)

        videoView = findViewById(R.id.videoView1)

        val videoPath = "android.resource://" + packageName + "/" + R.raw.pagoexitoso
        videoView.setVideoPath(videoPath)
        videoView.requestFocus()

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        videoView.setOnPreparedListener { mp ->
            // Comienza la reproducción una vez que el video esté listo
            mp.start()
        }
    } fun seguir(view: View){
        startActivity(Intent(this,SeguimientoPedidoActivity::class.java))
    }

}
