package com.artemissoftware.soterialogin.ui.splash

import android.animation.ObjectAnimator
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.databinding.FragmentSplashBinding
import com.artemissoftware.soterialogin.databinding.FragmentTutorialBinding


class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var binding: FragmentSplashBinding

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSplashBinding.bind(view)

        ObjectAnimator.ofInt(binding.progressBar, "progress", 90).apply {
            duration = 8000L
            start()
        }
    }


}