package com.artemissoftware.soterialogin.ui.tutorial

import android.animation.ArgbEvaluator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artemissoftware.soterialogin.databinding.FragmentAvatarSelectionBinding
import com.artemissoftware.soterialogin.databinding.FragmentTutorialBinding
import com.artemissoftware.soterialogin.ui.tutorial.adapters.TutorialAdapter
import com.artemissoftware.soterialogin.ui.tutorial.adapters.TutorialListener
import com.google.android.material.tabs.TabLayoutMediator
import android.animation.ValueAnimator

import android.animation.ValueAnimator.AnimatorUpdateListener
import com.artemissoftware.soterialogin.R
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback


class TutorialFragment : Fragment(R.layout.fragment_tutorial), TutorialListener {

    private lateinit var binding: FragmentTutorialBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTutorialBinding.bind(view)

        setupViewPager()


        var colorFrom = resources.getColor(R.color.white)
        var colorTo = resources.getColor(R.color.colorLink)
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), colorFrom, colorTo)
        colorAnimation.duration = 1000 // milliseconds
        colorAnimation.addUpdateListener { animator -> binding.vpTutorial.setBackgroundColor(animator.animatedValue as Int) }

        var colorFrom_2 = resources.getColor(R.color.colorLink)
        var colorTo_2 = resources.getColor(R.color.white)
        val colorAnimation_2 = ValueAnimator.ofObject(ArgbEvaluator(), colorFrom_2, colorTo_2)
        colorAnimation_2.duration = 1000 // milliseconds
        colorAnimation_2.addUpdateListener { animator -> binding.vpTutorial.setBackgroundColor(animator.animatedValue as Int) }
        //colorAnimation.start()

        var current = colorAnimation

        binding.vpTutorial.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)

                if(position == 1 || position == 3){
                    current = colorAnimation_2
                }
                else{
                    current = colorAnimation
                }
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                //Log.e("Selected_Page", position.toString())
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

                if (state == 2){
                    current.start()
                }
            }
        })
    }

    private fun setupViewPager(){

        val fragments = listOf<Fragment>(OnboardingDiscountsFragment(), OnboardingDiscountsFragment() , OnboardingHelpFragment(this))

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