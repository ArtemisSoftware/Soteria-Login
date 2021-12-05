package com.artemissoftware.soterialogin.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.databinding.ActivityLoginBinding
import com.artemissoftware.soterialogin.databinding.FragmentLoginBinding


class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding = FragmentLoginBinding.bind(view)

        initClickListeners()
    }

    private fun initClickListeners(){

        binding.txtCreateAccount.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnLogin.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_tutorialFragment)
        }

        binding.btnEmail.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_emailConfirmationFragment)
        }

        binding.txtRecoverPassword.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_birthDateFragment)
        }
    }

}