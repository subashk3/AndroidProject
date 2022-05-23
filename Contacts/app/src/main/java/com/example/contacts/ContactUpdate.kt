package com.example.contacts

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.contacts.databinding.FragmentContactUpdateBinding


class ContactUpdate : Fragment() {
    private lateinit var binding: FragmentContactUpdateBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity() as MainActivity).apply {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            invalidateOptionsMenu()  //Refresh menu
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contact_update, container, false)
        binding.saveContact.setOnClickListener {
        Log.d("My","Saved ${binding.userName.text} ")
        }
        return binding.root
    }

    override fun onDetach() { // detach the fragment
        super.onDetach()
        (requireActivity() as MainActivity).apply {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            invalidateOptionsMenu()
        }
    }

}