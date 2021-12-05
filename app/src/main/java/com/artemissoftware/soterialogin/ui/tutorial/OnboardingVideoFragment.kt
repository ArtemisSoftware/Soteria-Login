package com.artemissoftware.soterialogin.ui.tutorial

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import androidx.fragment.app.Fragment
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.databinding.FragmentOnboardingVideoBinding


class OnboardingVideoFragment : Fragment(R.layout.fragment_onboarding_video) {

    private lateinit var binding: FragmentOnboardingVideoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding = FragmentOnboardingVideoBinding.bind(view)


        binding.videoview.setOnPreparedListener {
            binding.videoview.start()
        }

        binding.videoview.setOnCompletionListener {
            binding.videoview.stopPlayback()
        }

        try {
            val mediacontroller = MediaController(requireContext())
            mediacontroller.setAnchorView(binding.videoview)
            val video: Uri = Uri.parse("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
            binding.videoview.setMediaController(mediacontroller)
            binding.videoview.setVideoURI(video)
        } catch (e: Exception) {

            e.printStackTrace()
        }
        binding.videoview.requestFocus()

    }


}