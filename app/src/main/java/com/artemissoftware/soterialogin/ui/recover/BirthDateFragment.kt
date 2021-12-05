package com.artemissoftware.soterialogin.ui.recover

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.databinding.FragmentBirthDateBinding
import com.artemissoftware.soterialogin.databinding.FragmentLoginBinding


class BirthDateFragment : Fragment(R.layout.fragment_birth_date) {

    private lateinit var binding: FragmentBirthDateBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding = FragmentBirthDateBinding.bind(view)

        initClickListeners()

        binding.txtInputDate.hint = "____"
        binding.txtInputDate.mask = "##.##"


    }

    private fun initClickListeners(){

        binding.btnConfirm.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.txtInputDate.doOnTextChanged { text, start, before, count ->

            text?.let {
                binding.btnConfirm.isEnabled = !it.contains('_')
            }
        }

    }
}