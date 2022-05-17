package com.example.viewmodel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var counter = 0
    val currentCounter: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}