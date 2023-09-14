package com.example.onepieceapps.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.onepieceapps.R
import com.example.onepieceapps.databinding.FragmentHomeBinding
import com.example.onepieceapps.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_homeFragment)
        }
        return binding.root
    }
}