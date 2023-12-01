package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val auth = FirebaseAuth.getInstance()

        val edtemail: EditText = findViewById(R.id.edtemail)
        val edtpassw: EditText = findViewById(R.id.edtpassw)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val btnRegister: Button = findViewById(R.id.btnRegister)

        btnLogin.setOnClickListener {
            val correo: String = edtemail.text.toString()
            val clave: String = edtpassw.text.toString()

            auth.signInWithEmailAndPassword(correo, clave)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Verificar si el usuario es administrador
                        if (correo.endsWith("@admin.com")) {
                            startActivity(Intent(this, Menu_principalActivity::class.java))
                        } else if (correo.endsWith("@seller.com")) {
                            // Verificar si el usuario es vendedor
                            startActivity(Intent(this, PrincipalVendedorActivity::class.java))
                        } else {
                            // Usuario normal, dirigir al menú principal
                            Snackbar
                                .make(
                                    findViewById(android.R.id.content),
                                    "Usuario validado",
                                    Snackbar.LENGTH_LONG
                                ).show()
                            startActivity(Intent(this, PrincipalActivity::class.java))
                        }
                    } else {
                        Snackbar
                            .make(
                                findViewById(android.R.id.content),
                                "Credenciales incorrectas",
                                Snackbar.LENGTH_LONG
                            ).show()

                    }
                }
        }
    }
}
