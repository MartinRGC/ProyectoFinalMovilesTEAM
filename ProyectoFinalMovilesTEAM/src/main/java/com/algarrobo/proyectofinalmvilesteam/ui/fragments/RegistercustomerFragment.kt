package com.algarrobo.proyectofinalmvilesteam.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.algarrobo.proyectofinalmvilesteam.R


class RegistercustomerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_registercustomer, container, false)

        val edtnamecon: EditText = view.findViewById(R.id.edtusercutomer)
        val edtpsswcon: EditText = view.findViewById(R.id.edtpsswcustomer)
        val edtphonecon: EditText = view.findViewById(R.id.edtphonecustomer)
        val edtdatecon: EditText = view.findViewById(R.id.edtdatecustomer)
        val edtemailcon: EditText = view.findViewById(R.id.edtemailcustomer)
        val btnsigncon: Button = view.findViewById(R.id.btnsigncustomer)
        val bncon: Button = view.findViewById(R.id.bncustomer)
        val btnsel: Button = view.findViewById(R.id.btnsel)
        return view

      btnsel.setOnClickListener {
           val intent = Intent(requireActivity(),RegistersellerFragment::class.java)
        }

        bncon.setOnClickListener {
            val intent = Intent(requireActivity(),RegistercustomerFragment::class.java)
        }
    }


}


