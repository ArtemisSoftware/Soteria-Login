package com.artemissoftware.soterialogin.ui.tutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.databinding.FragmentNotBotBinding
import com.artemissoftware.soterialogin.databinding.FragmentOnboardingHelpBinding
import com.artemissoftware.soterialogin.ui.tutorial.adapters.TutorialListener


class OnboardingHelpFragment(private val listener: TutorialListener) : Fragment(R.layout.fragment_onboarding_help) {

    private lateinit var binding: FragmentOnboardingHelpBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentOnboardingHelpBinding.bind(view)

        binding.btnVideoTutorial.setOnClickListener {

            listener.onVideoClick()
        }

    }
}