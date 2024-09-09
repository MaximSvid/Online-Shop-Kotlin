package com.example.onlineshopprojectkotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onlineshopprojectkotlin.R
import com.example.onlineshopprojectkotlin.databinding.FragmentStartBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    //test
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStart.setOnClickListener {
            findNavController().navigate(StartFragmentDirections.actionStartFragmentToHomeFragment())
            test()
        }
    }

    private fun test () {
        val database = FirebaseDatabase.getInstance("https://online-shop-project-kotlin-default-rtdb.europe-west1.firebasedatabase.app")
        val myRef = database.getReference("contacts")

        myRef.setValue("Hello, World!")
    }

}