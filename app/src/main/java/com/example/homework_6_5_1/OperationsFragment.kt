package com.example.homework_6_5_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.homework_6_5_1.databinding.FragmentOperationsBinding

class OperationsFragment : Fragment() {

    private lateinit var binding: FragmentOperationsBinding
    private val viewModel: PageViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOperationsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()
    }

    private fun initClick() {
        binding.plusBtn.setOnClickListener {
            viewModel.onIncrement()
        }
        binding.minusBtn.setOnClickListener {
            viewModel.onDecrement()
        }
    }

}