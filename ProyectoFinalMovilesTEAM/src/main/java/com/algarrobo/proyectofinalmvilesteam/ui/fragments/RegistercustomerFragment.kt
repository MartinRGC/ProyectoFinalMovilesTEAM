package com.algarrobo.proyectofinalmvilesteam.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.algarrobo.proyectofinalmvilesteam.LoginActivity
import com.algarrobo.proyectofinalmvilesteam.R


class RegistercustomerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_registercustomer, container, false)

        val edtrucsel: EditText = view.findViewById(R.id.edtrucsel)
        val edtpsswsel: EditText = view.findViewById(R.id.edtpsswsel)
        val edtphonesel: EditText = view.findViewById(R.id.edtphonesel)
        val edtdatesel: EditText = view.findViewById(R.id.edtdatesel)
        val edtemailsel: EditText = view.findViewById(R.id.edtrucsel)
        val btnsignsel: Button = view.findViewById(R.id.btnsignsel)
        val bncon: Button = view.findViewById(R.id.bncon)
        val btnsel: Button = view.findViewById(R.id.btnsel)
        return view

        btnsel.setOnClickListener {
            val intent = Intent(this, RegistersellerFragment::class.java)
            startActivity(intent)
        }
    }


}


