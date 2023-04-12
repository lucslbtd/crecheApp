package com.example.crecheapp.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.crecheapp.R
import com.example.crecheapp.databinding.FragmentTutorialCrecheBinding

class TutorialCrecheFragment : Fragment() {

    private lateinit var binding: FragmentTutorialCrecheBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTutorialCrecheBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationFragment()
    }

    private fun navigationFragment() = with(binding) {
        proceedButton.setOnClickListener {
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_tutorialCrecheFragment_to_tutorialLocationFragment) }
        }
    }
}
