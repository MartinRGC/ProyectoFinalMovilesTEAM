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
                        // Verificar el tipo de usuario después del inicio de sesión exitoso
                        if (correo.endsWith("@seller.com")) {
                            val sellerDomain = correo.split("@")[0].toLowerCase()
                            when {
                                sellerDomain == "mcdonalds" -> {
                                    // Redirigir al menú de McDonald's
                                    startActivity(Intent(this, McDonaldsMenuActivity::class.java))
                                }
                                sellerDomain == "bembos" -> {
                                    // Redirigir al menú de Bembos
                                    startActivity(Intent(this, BembosMenuActivity::class.java))
                                }
                                sellerDomain == "dominos" -> {
                                    // Redirigir al menú de Domino's
                                    startActivity(Intent(this, DominosMenuActivity::class.java))
                                }
                                else -> {
                                    // Redirigir a una actividad genérica para otros vendedores
                                    startActivity(Intent(this, Menu_principalActivity::class.java))
                                }
                            }
                        } else if (correo.endsWith("@admin.com")) {
                            // Redirigir al menú principal para administradores
                            startActivity(Intent(this, PrincipalActivity::class.java))
                        } else {
                            // Redirigir a una actividad genérica para otros tipos de usuarios
                            Snackbar
                                .make(
                                    findViewById(android.R.id.content),
                                    "Usuario validado",
                                    Snackbar.LENGTH_LONG
                                ).show()
                            startActivity(Intent(this, PrincipalActivity::class.java))
                        }
                    } else {
                        // Manejar errores durante el inicio de sesión
                        Snackbar
                            .make(
                                findViewById(android.R.id.content),
                                "Error al iniciar sesión",
                                Snackbar.LENGTH_LONG
                            ).show()
                        // En caso de error, no redirigir a otra actividad de inicio de sesión
                    }
                }
        }
        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterCustomerActivity::class.java)) // redirección al fragmento de registro
        }
    }
}
