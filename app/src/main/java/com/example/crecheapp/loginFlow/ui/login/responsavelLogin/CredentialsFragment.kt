package com.example.crecheapp.loginFlow.ui.login.responsavelLogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.crecheapp.R
import com.example.crecheapp.databinding.FragmentCredentialsScreenBinding

class CredentialsFragment : Fragment() {

    private lateinit var binding: FragmentCredentialsScreenBinding
    private val viewModel: SignUpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCredentialsScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationFragment()
    }

    private fun navigationFragment() = with(binding) {
        btnRegistrate.setOnClickListener {
            viewModel.signUpData.user.email = email.text.toString()
            viewModel.signUpData.user.password = fillPassword.text.toString()
            viewModel.signUpData.user.account_type = "pai"
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_credentialsFragment_to_successFragment)
            }
        }
    }

}
