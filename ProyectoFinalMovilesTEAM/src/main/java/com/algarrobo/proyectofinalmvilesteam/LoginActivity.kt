package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.algarrobo.proyectofinalmvilesteam.ui.fragments.RegistercustomerFragment
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val auth = FirebaseAuth.getInstance()

        val edtemail: EditText = findViewById(R.id.edtemail)
        val edtpassw: EditText = findViewById(R.id.edtpassw)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val btnRegister: Button = findViewById(R.id.btnRegister)
         // instancia de Base de Datos

        btnLogin.setOnClickListener {

            var correo: String = edtemail.text.toString()
            var clave: String = edtpassw.text.toString()

            auth.signInWithEmailAndPassword(correo,clave)
                .addOnCompleteListener(this){task ->
                    if (task.isSuccessful){
                        Snackbar
                            .make(
                                findViewById(android.R.id.content)
                                ,"Usuario validado"
                                , Snackbar.LENGTH_LONG
                            ).show()
                        startActivity(Intent(this, MainActivity::class.java))
                    }else{
                        Snackbar
                            .make(
                                findViewById(android.R.id.content)
                                ,"Usuario no encontrado"
                                , Snackbar.LENGTH_LONG
                            ).show()
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                }
        }
        btnRegister.setOnClickListener{
           startActivity(Intent(this, RegistercustomerFragment::class.java)) // redirección al fragment registro
        }
    }
}