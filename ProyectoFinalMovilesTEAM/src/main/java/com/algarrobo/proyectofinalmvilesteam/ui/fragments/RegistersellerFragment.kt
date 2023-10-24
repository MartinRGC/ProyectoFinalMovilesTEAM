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


class RegistersellerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_registerseller, container, false)

        val edtrucsel: EditText = view.findViewById(R.id.edtusercutomer)
        val edtpsswsel: EditText = view.findViewById(R.id.edtpsswcustomer)
        val edtphonesel: EditText = view.findViewById(R.id.edtphonecustomer)
        val edtdatesel: EditText = view.findViewById(R.id.edtdatecustomer)
        val edtemailsel: EditText = view.findViewById(R.id.edtusercutomer)
        val btnsignsel: Button = view.findViewById(R.id.btnsigncustomer)
        val bncon: Button = view.findViewById(R.id.bncustomer)
        val btnsel: Button = view.findViewById(R.id.btnsel)
        return view

        btnsel.setOnClickListener {
            val intent = Intent(requireActivity(), RegistersellerFragment::class.java)
        }

        bncon.setOnClickListener {
            val intent = Intent(requireActivity(), RegistercustomerFragment::class.java)
        }
    }

  
}