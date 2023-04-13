package com.example.crecheapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.crecheapp.databinding.FragmentIttersFilterBinding

class IttersFragment : Fragment() {

    private lateinit var binding: FragmentIttersFilterBinding
    private var onDataListener: OnDataListener? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIttersFilterBinding.inflate(inflater, container, false)
        return binding.root
    }


    // Define a interface para enviar as informações coletadas de volta para a Activity
    /*interface OnDataListener {
        fun onDataReceived(data: String)
    }*/

    // Define o listener
    fun setOnDataListener(listener: OnDataListener) {
        onDataListener = listener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ao clicar no botão, colete as informações e envie de volta para a Activity
        binding.btnSearch.setOnClickListener {

            val data = binding.editTextValor.text.toString()
            onDataListener?.onDataReceived(data)

            // Remova a Fragment
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}
