package com.artemissoftware.soterialogin.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.databinding.FragmentAvatarSelectionBinding
import com.artemissoftware.soterialogin.databinding.FragmentRegisterCompleteBinding


class RegisterCompleteFragment : Fragment(R.layout.fragment_register_complete) {

    private lateinit var binding: FragmentRegisterCompleteBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterCompleteBinding.bind(view)
        initClickListeners()
    }

    private fun initClickListeners(){

        binding.btnLogin.setOnClickListener{
            findNavController().popBackStack(R.id.loginFragment, true)
        }
    }
}