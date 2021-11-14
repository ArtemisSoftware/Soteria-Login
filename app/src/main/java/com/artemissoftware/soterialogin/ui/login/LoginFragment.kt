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
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLoginBinding.inflate(layoutInflater)

        initClickListeners()
    }

    private fun initClickListeners(){

        binding.txtCreateAccount.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)

        }


    }

}