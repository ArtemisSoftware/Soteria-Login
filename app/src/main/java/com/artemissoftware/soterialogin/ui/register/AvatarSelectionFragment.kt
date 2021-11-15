package com.artemissoftware.soterialogin.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.data.LoginDataSource.Companion.AVATARS
import com.artemissoftware.soterialogin.databinding.FragmentAvatarSelectionBinding
import com.artemissoftware.soterialogin.ui.register.adapters.AvatarAdapter
import com.artemissoftware.soterialogin.ui.plans.MainActivity

import android.content.Intent

import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.navigation.fragment.findNavController


class AvatarSelectionFragment : Fragment(R.layout.fragment_avatar_selection) {

    private lateinit var binding: FragmentAvatarSelectionBinding

    //private val avatarsAdapter by lazy { AvatarAdapter(AVATARS)  }

    lateinit var adapter: AvatarAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAvatarSelectionBinding.bind(view)

        setupGridView()
    }

    private fun setupGridView(){

        adapter = AvatarAdapter(requireContext(), R.layout.item_avatar, AVATARS)
        binding.gridAvatars.adapter = adapter


        binding.gridAvatars.setOnItemClickListener{ parent, view, position, id ->
            adapter.update(position)
        }


        binding.btnContinue.setOnClickListener{
            findNavController().navigate(R.id.action_avatarSelectionFragment_to_registerCompleteFragment)
        }

    }
}