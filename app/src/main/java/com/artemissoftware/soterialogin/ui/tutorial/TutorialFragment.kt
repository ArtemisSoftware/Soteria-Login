package com.artemissoftware.soterialogin.ui.tutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.databinding.FragmentAvatarSelectionBinding
import com.artemissoftware.soterialogin.databinding.FragmentTutorialBinding
import com.artemissoftware.soterialogin.ui.tutorial.adapters.TutorialAdapter


class TutorialFragment : Fragment(R.layout.fragment_tutorial) {

    private lateinit var binding: FragmentTutorialBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTutorialBinding.bind(view)

        setupViewPager()
    }

    private fun setupViewPager(){

        val fragments = listOf<Fragment>(OnboardingDiscountsFragment(), OnboardingHelpFragment())

        val tutorialAdapter = TutorialAdapter(this, fragments =  fragments)
        binding.vpTutorial.adapter = tutorialAdapter
    }
}