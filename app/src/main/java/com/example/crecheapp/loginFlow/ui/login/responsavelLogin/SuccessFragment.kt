package com.example.crecheapp.loginFlow.ui.login.responsavelLogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.crecheapp.R
import com.example.crecheapp.databinding.SucessScreenBinding

class SuccessFragment : Fragment() {

    private lateinit var binding: SucessScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SucessScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationToMap()
    }

    private fun navigationToMap() = with(binding) {
        btnContinue.setOnClickListener {
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_successFragment_to_mapsActivity) }
        }
    }
}
