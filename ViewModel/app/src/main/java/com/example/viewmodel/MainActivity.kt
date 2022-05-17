package com.example.viewmodel

//import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.databinding.ActivityMainBinding
import com.example.viewmodel.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_main)

        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        myViewModel.currentCounter.observe(this
        ) { binding.textViewCount.text = it.toString() }

        binding.plusButton.setOnClickListener { incrementCounterValue() }
        binding.minusButton.setOnClickListener { decrementCounterValue() }
        binding.resetButton.setOnClickListener { resetCounterValue() }
    }

    private fun resetCounterValue() {
        myViewModel.currentCounter.value = (0.also { myViewModel.counter = it })
        binding.textViewCount.text = myViewModel.currentCounter.value.toString()
    }

    private fun decrementCounterValue() {
        myViewModel.currentCounter.value = --myViewModel.counter
        binding.textViewCount.text = myViewModel.currentCounter.value.toString()
    }

    private fun incrementCounterValue() {
        myViewModel.currentCounter.value = ++myViewModel.counter
        binding.textViewCount.text = myViewModel.currentCounter.value.toString()
    }


}