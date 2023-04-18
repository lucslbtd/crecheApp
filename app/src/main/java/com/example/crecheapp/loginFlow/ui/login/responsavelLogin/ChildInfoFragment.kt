package com.example.crecheapp.loginFlow.ui.login.responsavelLogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.crecheapp.R
import com.example.crecheapp.databinding.FragmentChildInfoBinding

class ChildInfoFragment : Fragment() {

    private lateinit var binding: FragmentChildInfoBinding
    private val viewModel: SignUpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChildInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationFragment()
    }

    private fun navigationFragment() = with(binding) {
        proceedButton.setOnClickListener {
            viewModel.signUpData.child.name = nomeCriancaTxt.toString()
            viewModel.signUpData.child.birthday_date = edtBirthdayChild.toString()
            viewModel.signUpData.child.gender = "Masculino"
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_childInfoFragment_to_credentialsFragment)
            }
        }
    }
}
