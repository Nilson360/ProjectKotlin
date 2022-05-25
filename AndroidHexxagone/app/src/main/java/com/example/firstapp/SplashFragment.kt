package com.example.firstapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.firstapp.databinding.SplashLayoutBinding

class SplashFragment : Fragment() {
    private lateinit var binding: SplashLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SplashLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
            val name = binding.editT.text.toString()
            if (!name.isNullOrBlank()) {
                findNavController().navigate(
                    SplashFragmentDirections.actionSplashFragmentToHomeFragment2(
                        name
                    )
                )
            } else {
                Toast.makeText(requireContext(), "Entrez votre nom", Toast.LENGTH_LONG).show()
            }
        }

    }
}