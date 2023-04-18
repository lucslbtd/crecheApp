package com.example.crecheapp.loginFlow.ui.login.responsavelLogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.crecheapp.R
import com.example.crecheapp.databinding.FragmentCadastroInfoBasicasBinding

class BasicInfoFragment : Fragment() {

    private lateinit var binding: FragmentCadastroInfoBasicasBinding
    private val viewModel: SignUpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroInfoBasicasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationFragment()
    }

    private fun navigationFragment() = with(binding) {
        proceedButton.setOnClickListener {
            viewModel.signUpData.user.name = edtNameParent.toString()
            viewModel.signUpData.user.birthday_date = edtParentBirthday.toString()
            viewModel.signUpData.user.phone_number = edtContactParent.toString()
            viewModel.signUpData.user.document = edtCpfParent.toString()
            viewModel.signUpData.user.gender = "Masculino"
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_basicInfoFragment_to_adressInfoFragment) }
        }
    }

    /*private fun verifyFields(): Boolean = with(binding) {
        val txtNameParent = edtNameParent.text
        val txtBirthdayParent = edtBirthdayParent.text
        val txtContactParent = edtContactParent.text
        val txtCPFParent = edtCpfParent.text
        when {
            txtEmail.isEmpty() && txtPassword.isEmpty() -> {
                Toast.makeText(context, "Os campos não foram preenchidos", Toast.LENGTH_SHORT)
                    .show()
                false
            }
            txtEmail.isEmpty() -> {
                Toast.makeText(context, "Preencha seu email", Toast.LENGTH_SHORT).show()
                false
            }
            txtPassword.isEmpty() -> {
                Toast.makeText(context, "Preencha sua senha", Toast.LENGTH_SHORT).show()
                false
            }
            else -> {
                true
            }
        }
    }*/
}
