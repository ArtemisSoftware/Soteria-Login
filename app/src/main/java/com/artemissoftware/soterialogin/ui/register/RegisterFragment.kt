package com.artemissoftware.soterialogin.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.databinding.FragmentLoginBinding
import com.artemissoftware.soterialogin.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterBinding.inflate(layoutInflater)

        initClickListeners()
    }

    private fun initClickListeners(){

        binding.btnRegister.setOnClickListener {

            findNavController().navigate(R.id.action_registerFragment_to_termsConditionsFragment)

        }


    }
}