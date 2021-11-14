package com.artemissoftware.soterialogin.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.databinding.FragmentAvatarSelectionBinding
import com.artemissoftware.soterialogin.databinding.FragmentSafetyQuestionsBinding


class AvatarSelectionFragment : Fragment(R.layout.fragment_avatar_selection) {

    private lateinit var binding: FragmentAvatarSelectionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAvatarSelectionBinding.bind(view)

        setupGridView()
    }

    private fun setupGridView(){

    }
}