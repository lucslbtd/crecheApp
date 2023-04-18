package com.example.crecheapp.loginFlow.ui.login.responsavelLogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.crecheapp.R
import com.example.crecheapp.databinding.FragmentAdressScreenBinding

class AdressInfoFragment : Fragment() {

    private lateinit var binding: FragmentAdressScreenBinding
    private val viewModel: SignUpViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdressScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationFragment()
    }

    private fun navigationFragment() = with(binding) {
        proceedButton.setOnClickListener {
            viewModel.signUpData.address.street = ruaTxt.toString()
            viewModel.signUpData.address.city = cidade.toString()
            viewModel.signUpData.address.postal_code = cep.toString()
            viewModel.signUpData.address.complement = complemento.toString()

            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_adressInfoFragment_to_childInfoFragment)
            }
        }
    }
}
