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
import com.artemissoftware.soterialogin.databinding.FragmentTermsConditionsBinding


class TermsConditionsFragment : Fragment(R.layout.fragment_terms_conditions) {


    private lateinit var binding: FragmentTermsConditionsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTermsConditionsBinding.bind(view)

        initClickListeners()
    }

    private fun initClickListeners(){

        binding.btnAccept.setOnClickListener {

            findNavController().navigate(R.id.action_termsConditionsFragment_to_safetyQuestionsFragment)

        }


    }
}