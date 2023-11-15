package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.algarrobo.proyectofinalmvilesteam.models.SellerModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

class RegisterSellerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_seller)

        val btnCustomerSel: Button = findViewById(R.id.bncustomer)
        val btnSellerSe: Button = findViewById(R.id.btnsel)
        val txtRUC: EditText = findViewById(R.id.edtusercutomer)
        val txtPasswordSel: EditText = findViewById(R.id.btnlistusuarios)
        val txtPhoneSel: EditText = findViewById(R.id.edtphonecustomer)
        val txtDateofBirthSel: EditText = findViewById(R.id.edtdatecustomer)
        val txtEmailSel: EditText = findViewById(R.id.btnlistusuarios)
        val btnSingupSel: Button = findViewById(R.id.btnEnviar)

        val auth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()
        val collectionRef = db.collection("Sellers")

        btnSellerSe.setOnClickListener{
            startActivity(Intent(this, RegisterSellerActivity::class.java))
        }

        btnCustomerSel.setOnClickListener{
            startActivity(Intent(this, RegisterCustomerActivity::class.java))
        }


        btnSingupSel.setOnClickListener {
            val RUC = txtRUC.text.toString()
            val clavevend = txtPasswordSel.toString()
            val telefonovend = txtPhoneSel.text.toString()
            val fechnacvend = txtDateofBirthSel.text.toString()
            val correovend = txtEmailSel.text.toString()

            auth.createUserWithEmailAndPassword(correovend,clavevend)
                .addOnCompleteListener(this){task ->
                    if (task.isSuccessful){
                        val user: FirebaseUser? = auth.currentUser
                        val uid = user?.uid

                        val sellermodel = SellerModel(RUC,clavevend,telefonovend,fechnacvend,correovend,uid.toString())
                        collectionRef.add(sellermodel)
                            .addOnCompleteListener{

                            }.addOnFailureListener{error ->
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