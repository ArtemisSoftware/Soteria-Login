package com.artemissoftware.soterialogin.ui.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.data.LoginDataSource
import com.artemissoftware.soterialogin.databinding.FragmentSafetyQuestionsBinding
import com.artemissoftware.soterialogin.ui.register.adapters.DragDropListener
import com.artemissoftware.soterialogin.ui.register.adapters.SafetyQuestionAdapter
import com.artemissoftware.soterialogin.ui.register.adapters.SafetyQuestionAnswerAdapter
import com.artemissoftware.soterialogin.util.DragListener
import com.bumptech.glide.Glide


class SafetyQuestionsFragment : Fragment(R.layout.fragment_safety_questions), DragDropListener {

    private lateinit var binding: FragmentSafetyQuestionsBinding

    private val questionsAdapter by lazy { SafetyQuestionAdapter(this, LoginDataSource.SAFETY_QUESTIONS) }
    //private val answerAdapter by lazy { SafetyQuestionAdapter(LoginDataSource.SAFETY_QUESTIONS)  }
    private val answerAdapter by lazy { SafetyQuestionAnswerAdapter(this)  }

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

        binding.emptyListTextView2.setOnDragListener(DragListener(this))

//        binding.rclAnswers.apply {
//            adapter = answerAdapter
//            layoutManager = LinearLayoutManager(
//                requireContext(),
//                LinearLayoutManager.HORIZONTAL,
//                false
//            )
//        }

    }

    override fun setEmptyList(visibility: Int) {
        binding.rclAnswers.visibility = if(visibility ==  View.GONE)  View.VISIBLE else  View.INVISIBLE
        //binding.emptyListTextView2.visibility = if(visibility ==  View.GONE)  View.INVISIBLE else  View.VISIBLE
    }

}