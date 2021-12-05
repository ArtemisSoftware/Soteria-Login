package com.artemissoftware.soterialogin.ui.tutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.databinding.FragmentNotBotBinding
import com.artemissoftware.soterialogin.databinding.FragmentOnboardingVideoBinding


class OnboardingVideoFragment : Fragment(R.layout.fragment_onboarding_video) {

    private lateinit var binding: FragmentOnboardingVideoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding = FragmentOnboardingVideoBinding.bind(view)


        binding.videoview.setVideoPath("http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4");
        binding.videoview.start();

    }
}