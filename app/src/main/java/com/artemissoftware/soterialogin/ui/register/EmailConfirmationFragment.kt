package com.artemissoftware.soterialogin.ui.register

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.databinding.FragmentEmailConfirmationBinding
import com.artemissoftware.soterialogin.databinding.FragmentRegisterCompleteBinding

class EmailConfirmationFragment : Fragment(R.layout.fragment_email_confirmation) {

    private lateinit var binding: FragmentEmailConfirmationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentEmailConfirmationBinding.bind(view)
        initClickListeners()
    }

    private fun initClickListeners(){

        binding.btnCheckEmail.setOnClickListener{

            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_APP_EMAIL)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            val chooser = Intent.createChooser(intent, "Email client")

            try{
                startActivity(chooser)
            }
            catch(e: ActivityNotFoundException){

            }
        }
    }
}