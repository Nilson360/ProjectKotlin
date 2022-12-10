package com.example.firstapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.navArgs
import com.example.firstapp.databinding.HomeLayoutBinding
import java.util.*


class HomeFragment : Fragment() {
    private lateinit var binding: HomeLayoutBinding
    private val navArgs: HomeFragmentArgs by navArgs()
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView.text = getString(
            R.string.bienvenue_dans_votre_espace_personnel,
            navArgs.name,
            viewModel.count.toString()
        )

        viewModel.count.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            binding.textView.text = getString(
                R.string.bienvenue_dans_votre_espace_personnel,
                navArgs.name,
                viewModel.count.value.toString()
            )
        })

        //Button plus
        binding.btn2.setOnClickListener {
            viewModel.plus()
        }
        binding.btn3.setOnClickListener {
            viewModel.count.value?.let {
                if (it >= 1) {
                    viewModel.moins()
                }
            }

        }

        // binding.textView.text = getString(R.string.bienvenue_dans_votre_espace_personnel, navArgs.name, count.toString())
    }
}