package com.example.crecheapp.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.crecheapp.R
import com.example.crecheapp.databinding.FragmentTutorialLocationBinding

class TutorialLocationFragment : Fragment() {

    private lateinit var binding: FragmentTutorialLocationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTutorialLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationFragment()
    }

    private fun navigationFragment() = with(binding) {
        proceedButton.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_tutorialLocationFragment_to_mapsActivity_FromTutorial)
            }
        }
    }
}
