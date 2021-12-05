package com.artemissoftware.soterialogin.ui.recover

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.databinding.FragmentBirthDateBinding
import com.artemissoftware.soterialogin.databinding.FragmentNotBotBinding


class NotBotFragment : Fragment(R.layout.fragment_not_bot) {

    private lateinit var binding: FragmentNotBotBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding = FragmentNotBotBinding.bind(view)

        initClickListeners()
    }

    private fun initClickListeners(){

        binding.btnConfirm.setOnClickListener {




            //--findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }


    }
}