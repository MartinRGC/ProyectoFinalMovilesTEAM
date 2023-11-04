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
        val lstRestau: ArrayList<RestauranteModel> = ArrayList()
        val rvRestau: RecyclerView = view.findViewById(R.id.rvRestau)

        db.collection("Restaurantes")
            .addSnapshotListener{snapshots, e->

                if(e!=null)
                {
                    Log.w("Firebase Warning","error",e)
                    return@addSnapshotListener
                }
                for(dc in snapshots!!.documentChanges){
                    when(dc.type){
                        DocumentChange.Type.ADDED -> {
                            lstRestau.add(
                                RestauranteModel(dc.document.data["image"].toString(),
                                    dc.document.data["nombre"].toString()))
                                rvRestau.adapter = RestauAdapter(lstRestau)
                        }
                        DocumentChange.Type.MODIFIED -> {
                            RestauranteModel(dc.document.data["image"].toString(),
                                dc.document.data["nombre"].toString())
                            rvRestau.adapter = RestauAdapter(lstRestau)
                        }
                        DocumentChange.Type.REMOVED -> {
                            Log.w("Firebase Warning", "REMOVED")
                        }
                    }
                }
                rvRestau.layoutManager = LinearLayoutManager(requireContext())
            }
        return view
        //uwu
    }
}