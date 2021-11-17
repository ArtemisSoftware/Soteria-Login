package com.artemissoftware.soterialogin.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.databinding.FragmentSplashBinding
import com.artemissoftware.soterialogin.databinding.FragmentTutorialBinding


class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var binding: FragmentSplashBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSplashBinding.bind(view)

    }
}