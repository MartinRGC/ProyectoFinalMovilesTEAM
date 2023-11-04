package com.algarrobo.proyectofinalmvilesteam.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.algarrobo.proyectofinalmvilesteam.R
import com.algarrobo.proyectofinalmvilesteam.fragments.adapter.RestauAdapter
import com.algarrobo.proyectofinalmvilesteam.models.RestauranteModel
import com.google.common.collect.ArrayTable
import com.google.firebase.Firebase
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore

class ListadoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_listado, container, false)

        val db = FirebaseFirestore.getInstance()
        var lstRestau: List<RestauranteModel>
        val rvRestau: RecyclerView = view.findViewById(R.id.rvRestau)

        db.collection("Restaurantes")
            .addSnapshotListener{snap, e->
                if (e != null) {
                    Log.i("ERROR", "Ocurrió un error")
                    return@addSnapshotListener
                }

                lstRestau = snap!!.documents.map { document ->
                    RestauranteModel(
                        document["imageUrl"].toString(),
                        document["nombre"].toString()
                    )
                }

                rvRestau.adapter = RestauAdapter(lstRestau)
                rvRestau.layoutManager = LinearLayoutManager(requireContext())
            }
        return view
    }
}