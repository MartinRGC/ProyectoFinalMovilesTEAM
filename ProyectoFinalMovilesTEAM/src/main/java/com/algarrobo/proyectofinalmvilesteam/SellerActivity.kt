package com.algarrobo.proyectofinalmvilesteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.algarrobo.proyectofinalmvilesteam.models.CustomerModel
import com.algarrobo.proyectofinalmvilesteam.models.SellerModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

class SellerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seller)

        val bnseller: Button = findViewById(R.id.bnseller)
        val btncust: Button = findViewById(R.id.btncust)
        val edtuservendedor: EditText = findViewById(R.id.edtuservendedor)
        val edtpsswvendedor: EditText = findViewById(R.id.edtpsswvendedor)
        val edtphonevendedor: EditText = findViewById(R.id.edtphonevendedor)
        val edtdatevendedor: EditText = findViewById(R.id.edtdatevendedor)
        val edtemailvendedor: EditText = findViewById(R.id.edtemailvendedor)
        val btnEnviarVendedor: Button = findViewById(R.id.btnEnviarVendedor)

        val auth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()
        val collectionRef = db.collection("Vendedores")

        btncust.setOnClickListener {
            startActivity(Intent(this, RegisterCustomerActivity::class.java))
        }

        btnEnviarVendedor.setOnClickListener {
            val Ruc = edtuservendedor.text.toString()
            val clavevend = edtpsswvendedor.text.toString()
            val telefonovend = edtphonevendedor.text.toString()
            val fechnacimvend = edtdatevendedor.text.toString()
            val correovend = edtemailvendedor.text.toString()

            auth.createUserWithEmailAndPassword(correovend,clavevend)
                .addOnCompleteListener(this){task->
                    if (task.isSuccessful){
                        //Se registró en Firebase Auth y deberá registrarse en Firestore
                        val user: FirebaseUser? = auth.currentUser
                        val uid = user?.uid

                        val sellermodel = SellerModel(Ruc,clavevend,telefonovend,fechnacimvend,correovend)
                        collectionRef.add(sellermodel)
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