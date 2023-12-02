package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class SeguimientoPedidoActivity: AppCompatActivity() {
    private lateinit var videoView2: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seguimientopedido)

        videoView2 = findViewById(R.id.videoView2)

        val videoPath = "android.resource://" + packageName + "/" + R.raw.a
        videoView2.setVideoPath(videoPath)
        videoView2.requestFocus()

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView2)
        videoView2.setMediaController(mediaController)

        videoView2.setOnPreparedListener { mp ->
            // Comienza la reproducción una vez que el video esté listo
            mp.start()
        }
    }
 fun calificar(view: View){
    startActivity(Intent(this,CalificaciónActivity::class.java))
}
    fun salir1(view: View){
        startActivity(Intent(this,PrincipalActivity::class.java))
    }

}
