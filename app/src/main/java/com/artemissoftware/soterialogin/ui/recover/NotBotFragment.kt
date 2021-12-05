package com.artemissoftware.soterialogin.ui.recover

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.databinding.FragmentBirthDateBinding
import com.artemissoftware.soterialogin.databinding.FragmentNotBotBinding
import com.squareup.duktape.DuktapeException
import mathjs.niltonvasques.com.mathjs.MathJS
import mathjs.niltonvasques.com.mathjs.MathJS.MathJSResult


class NotBotFragment : Fragment(R.layout.fragment_not_bot) {

    private lateinit var binding: FragmentNotBotBinding

    private var answer: String = ""


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding = FragmentNotBotBinding.bind(view)

        initClickListeners()
    }

    private fun initClickListeners(){

        binding.btnConfirm.setOnClickListener {

            val math = MathJS()

            try {
                val result: String = math.eval(answer)
                binding.txtInputMath.setText(result)

            }
            catch (e: DuktapeException){

            }
            finally {
                math.destroy()
            }


            //--findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }


        binding.txtInputMath.doOnTextChanged { text, start, before, count ->

            text?.let {
                answer = text?.toString()
            }
        }


    }
}