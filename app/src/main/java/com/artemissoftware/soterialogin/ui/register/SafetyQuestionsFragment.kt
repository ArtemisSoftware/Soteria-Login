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
import com.artemissoftware.soterialogin.databinding.FragmentSafetyQuestionsBinding


class SafetyQuestionsFragment : Fragment(R.layout.fragment_safety_questions) {

    private lateinit var binding: FragmentSafetyQuestionsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSafetyQuestionsBinding.inflate(layoutInflater)

        initClickListeners()
    }

    private fun initClickListeners(){

//        binding.txtCreateAccount.setOnClickListener {
//
//            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
//
//        }


    }
}