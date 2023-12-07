package com.example.onepiecelogin2.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.onepiecelogin2.R
import com.example.onepiecelogin2.databinding.FragmentLoginBinding
import kotlinx.coroutines.CoroutineScope
import org.koin.android.ext.android.inject
import org.koin.core.KoinApplication.Companion.init

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get () = _binding!!
    private val viewModel: LoginViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        init()
        observeData()
        return binding.root
    }

    private fun observeData() {
        with(viewModel){
            observeIsLogin().observe(requireActivity()){
                it.let { data ->
                    if (data != null){
                        findNavController().navigate(R.id.action_loginFragment_to_navigationParentFragment)
                    }
                }
            }
        }
    }

    private fun init() {
        with(binding) {
            btnLogin.setOnClickListener {
                if(etEmail.text.isNullOrBlank()){
                    etEmail.error = "Email Masih Kosong"
                }
                if(etPassword.text.isNullOrBlank()){
                    etPassword.error = "Password Masih Kosong"
                }
                if(!etEmail.text.isNullOrBlank() && !etPassword.text.isNullOrBlank()){
                    viewModel.getDataLogin(etEmail.text.toString(), etPassword.text.toString())
                }
            }
        }
        binding.tvRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

}