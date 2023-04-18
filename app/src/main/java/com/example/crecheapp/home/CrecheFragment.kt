package com.example.crecheapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.crecheapp.databinding.CrecheInfoScreenBinding
import com.example.crecheapp.databinding.FragmentIttersFilterBinding

class CrecheFragment : Fragment() {

    private lateinit var binding: CrecheInfoScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CrecheInfoScreenBinding.inflate(inflater, container, false)
        return binding.root
    }




}
