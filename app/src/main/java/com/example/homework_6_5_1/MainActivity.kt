package com.example.homework_6_5_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.homework_6_5_1.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:PageViewModel
    private lateinit var viewPager: ViewPager2
    private var tabTitle = arrayOf("Операции","Счёт","Выполненные операции")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.pager
        val pagerAdapter = FragmentPagerAdapter(this)
        viewPager.adapter = pagerAdapter
        val tabLayout = binding.tabLayout

        TabLayoutMediator(tabLayout,viewPager){
            tab,position ->
            tab.text = tabTitle[position]
        }.attach()

        viewModel = ViewModelProvider(this)[PageViewModel::class.java]

    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    companion object{
        const val NUM_PAGES = 3
    }

    private inner class FragmentPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {
            return NUM_PAGES
        }

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> OperationsFragment()
                1 -> CountFragment()
                2 -> HistoryFragment()
                else -> OperationsFragment()
            }
        }

    }

}