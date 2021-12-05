package com.artemissoftware.soterialogin.ui.tutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.databinding.FragmentAvatarSelectionBinding
import com.artemissoftware.soterialogin.databinding.FragmentTutorialBinding
import com.artemissoftware.soterialogin.ui.tutorial.adapters.TutorialAdapter
import com.artemissoftware.soterialogin.ui.tutorial.adapters.TutorialListener
import com.google.android.material.tabs.TabLayoutMediator


class TutorialFragment : Fragment(R.layout.fragment_tutorial), TutorialListener {

    private lateinit var binding: FragmentTutorialBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTutorialBinding.bind(view)

        setupViewPager()
    }

    private fun setupViewPager(){

        val fragments = listOf<Fragment>(OnboardingDiscountsFragment(), OnboardingHelpFragment(this))

        val tutorialAdapter = TutorialAdapter(this, fragments =  fragments)
        binding.vpTutorial.adapter = tutorialAdapter

        TabLayoutMediator(binding.tabLayout, binding.vpTutorial) { tab, position ->
            //Some implementation
        }.attach()
    }

    override fun onVideoClick() {
        findNavController().navigate(R.id.action_tutorialFragment_to_onboardingVideoFragment)
    }
}