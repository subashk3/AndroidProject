package com.example.fragmentcommunicate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.fragmentcommunicate.databinding.FragmentABinding

class FragmentA : Fragment() {
    private lateinit var communicator: Communicator
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
// Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentABinding>(
            inflater,
            R.layout.fragment_a,
            container,
            false
        )
        communicator = activity as Communicator
        binding.enterButton.setOnClickListener {
            communicator.pushData(binding.inputUser.text.toString())
        }
        return binding.root
    }


}














