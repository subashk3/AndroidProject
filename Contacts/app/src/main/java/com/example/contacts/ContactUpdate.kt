package com.example.contacts


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.contacts.database.ContactDataBase
import com.example.contacts.databinding.FragmentContactUpdateBinding
import com.example.contacts.model.ContactViewModel
import com.example.contacts.model.ContactViewModelFactory
import com.example.contacts.repository.ContactRepository


class ContactUpdate : Fragment() {
    private lateinit var binding: FragmentContactUpdateBinding

    private lateinit var contactViewModel: ContactViewModel
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
    ): View {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contact_update, container, false)
        binding.saveContact.setOnClickListener {

        }
       // val activity = activity as MainActivity?
        val contactDao = activity?.let { ContactDataBase.getInstance(it)?.contactDao() }
        val repository = contactDao?.let { ContactRepository(it) }
        val factory = repository?.let { ContactViewModelFactory(it) }

        contactViewModel = factory?.let {
            ViewModelProvider(
                this,
                it
            ).get(ContactViewModel::class.java)
        }!!

        binding.contact = contactViewModel
        binding.lifecycleOwner = this

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