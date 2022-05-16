package com.example.fragmentcommunicate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.fragmentcommunicate.databinding.FragmentBBinding
class FragmentB : Fragment() {
    private var inputString = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val secondBinding = DataBindingUtil.inflate<FragmentBBinding>(
            inflater,
            R.layout.fragment_b,
            container,
            false
        )
        inputString ="Welcome " + arguments?.getString("inputData").toString()+" ..!"
        secondBinding.outputText.text=inputString


        return secondBinding.root
    }
}