package com.artemissoftware.soterialogin.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.data.LoginDataSource
import com.artemissoftware.soterialogin.databinding.FragmentLoginBinding
import com.artemissoftware.soterialogin.databinding.FragmentRegisterBinding
import com.artemissoftware.soterialogin.databinding.FragmentSafetyQuestionsBinding
import com.artemissoftware.soterialogin.ui.register.adapters.SafetyQuestionAdapter


class SafetyQuestionsFragment : Fragment(R.layout.fragment_safety_questions) {

    private lateinit var binding: FragmentSafetyQuestionsBinding

    private val questionsAdapter by lazy { SafetyQuestionAdapter(LoginDataSource.SAFETY_QUESTIONS) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSafetyQuestionsBinding.bind(view)

        initClickListeners()
        setupRecyclerView()
    }

    private fun initClickListeners(){

//        binding.txtCreateAccount.setOnClickListener {
//
//            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
//
//        }


    }

    private fun setupRecyclerView(){

        binding.rclQuestions.apply {
            adapter = questionsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}