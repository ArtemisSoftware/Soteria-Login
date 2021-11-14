package com.artemissoftware.soterialogin.ui.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.data.LoginDataSource
import com.artemissoftware.soterialogin.databinding.FragmentSafetyQuestionsBinding
import com.artemissoftware.soterialogin.ui.register.adapters.SafetyQuestionAdapter
import com.artemissoftware.soterialogin.ui.register.adapters.SafetyQuestionAnswerAdapter


class SafetyQuestionsFragment : Fragment(R.layout.fragment_safety_questions) {

    private lateinit var binding: FragmentSafetyQuestionsBinding

    private val questionsAdapter by lazy { SafetyQuestionAdapter(LoginDataSource.SAFETY_QUESTIONS) }
    //private val answerAdapter by lazy { SafetyQuestionAdapter(LoginDataSource.SAFETY_QUESTIONS)  }
    private val answerAdapter by lazy { SafetyQuestionAnswerAdapter()  }

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

        //answerAdapter.items = LoginDataSource.SAFETY_QUESTIONS

        binding.rclQuestions.apply {
            adapter = questionsAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setOnDragListener(null)
        }

        binding.rclAnswers.apply {
            adapter = answerAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )

            //setOnDragListener(null)
        }


//        binding.rclAnswers.apply {
//            adapter = answerAdapter
//            layoutManager = LinearLayoutManager(
//                requireContext(),
//                LinearLayoutManager.HORIZONTAL,
//                false
//            )
//        }

    }

}