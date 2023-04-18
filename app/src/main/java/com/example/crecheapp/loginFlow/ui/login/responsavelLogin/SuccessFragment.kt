package com.example.crecheapp.loginFlow.ui.login.responsavelLogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.crecheapp.R
import com.example.crecheapp.databinding.SucessScreenBinding
import com.example.crecheapp.loginFlow.model.SignUpRequest

class SuccessFragment : Fragment() {

    private lateinit var binding: SucessScreenBinding
    private val viewModel: SignUpViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //onClickRegisterButton()
        binding = SucessScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationToMap()
    }

    private fun navigationToMap() = with(binding) {
        btnContinue.setOnClickListener {
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_successFragment_to_tutorialActivity) }
        }
    }

    private fun onClickRegisterButton() {
        val signUpRequest = SignUpRequest(
            viewModel.signUpData.user,
            viewModel.signUpData.child,
            viewModel.signUpData.address
        )
        viewModel.register(signUpRequest)
    }
}
