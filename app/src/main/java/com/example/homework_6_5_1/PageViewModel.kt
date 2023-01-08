package com.example.homework_6_5_1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PageViewModel: ViewModel() {
    var mCount = MutableLiveData<Int>()
    var mOperation = MutableLiveData<ArrayList<String>>()
    private var operation = arrayListOf<String>()
    private var count = 0

    fun onIncrement(){
        ++count
        mCount.value = count
        operation.add("+")
        mOperation.value = operation
    }

    fun onDecrement(){
        --count
        mCount.value = count
        operation.add("-")
        mOperation.value = operation
    }

}