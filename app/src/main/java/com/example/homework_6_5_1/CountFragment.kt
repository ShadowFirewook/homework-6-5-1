package com.example.homework_6_5_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.homework_6_5_1.databinding.FragmentCountBinding

class CountFragment : Fragment() {

    private lateinit var binding: FragmentCountBinding
    private val viewModel:PageViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
    }

    private fun initObserver() {
        viewModel.mCount.observe(viewLifecycleOwner){
            binding.count.text = it.toString()
        }
    }

}