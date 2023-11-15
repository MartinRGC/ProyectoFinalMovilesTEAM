package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.algarrobo.proyectofinalmvilesteam.models.CustomerModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

class RegisterCustomerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_customer)

        val  bncustomer: Button = findViewById(R.id.bncustomer)
        val btnsel: Button = findViewById(R.id.btnsel)
        val edtusercutomer: EditText = findViewById(R.id.edtusercutomer)
        val edtpsswcustomer: EditText = findViewById(R.id.edtpsswcustomer)
        val edtphonecustomer: EditText = findViewById(R.id.edtphonecustomer)
        val edtdatecustomer: EditText = findViewById(R.id.edtdatecustomer)
        val edtemailcustomer: EditText = findViewById(R.id.btnlistusuarios)
        val btnsigncustomer: Button = findViewById(R.id.btnEnviar)

        val auth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()
        val collectionRef = db.collection("Customers")

        btnsel.setOnClickListener{
            startActivity(Intent(this, RegisterSellerActivity::class.java))
        }

        bncustomer.setOnClickListener{
            startActivity(Intent(this, RegisterCustomerActivity::class.java))
        }

        btnsigncustomer.setOnClickListener{
            val comprador = edtusercutomer.text.toString()
            val clavecomp = edtpsswcustomer.text.toString()
            val telefonocomp = edtphonecustomer.text.toString()
            val fechnacimcomp = edtdatecustomer.text.toString()
            val correocomp = edtemailcustomer.text.toString()

            auth.createUserWithEmailAndPassword(correocomp,clavecomp)
                .addOnCompleteListener(this){task->
                    if (task.isSuccessful){
                        //Se registró en Firebase Auth y deberá registrarse en Firestore
                        val user: FirebaseUser? = auth.currentUser
                        val uid = user?.uid

                        val customermodel = CustomerModel(comprador,clavecomp,telefonocomp,fechnacimcomp,correocomp)
                        collectionRef.add(customermodel)
                            .addOnCompleteListener{

                            }.addOnFailureListener{error->
                                Snackbar
                                    .make(
                                        findViewById(android.R.id.content)
                                        ,"Ocurrió un error al registrar el modelo"
                                        , Snackbar.LENGTH_LONG
                                    ).show()
                            }
                        Snackbar
                            .make(
                                findViewById(android.R.id.content)
                                ,"Registro exitoso del usuario"
                                , Snackbar.LENGTH_LONG
                            ).show()


                    }else{
                        Snackbar
                            .make(
                                findViewById(android.R.id.content)
                                ,"Ocurrió un error al registrarse"
                                , Snackbar.LENGTH_LONG
                            ).show()


                            }
                    }

                }

        }

    }
