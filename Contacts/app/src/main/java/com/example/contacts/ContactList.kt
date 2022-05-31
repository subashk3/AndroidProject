package com.example.contacts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts.adpater.ContactAdapter
import com.example.contacts.databinding.FragmentContactListBinding
import com.example.contacts.model.MyViewModel

class ContactList : Fragment() {

    private lateinit var secondBinding: FragmentContactListBinding
    private lateinit var myViewModel: MyViewModel
    private lateinit var contactAdapter: ContactAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        // Inflate the layout for this fragment
        secondBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_contact_list,
            container,
            false
        )

        val recyclerView = secondBinding.contactRecyclerView

        recyclerView.layoutManager = LinearLayoutManager(context)

        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]

        myViewModel.getUserContactList().observe(viewLifecycleOwner) { updatedList ->

            contactAdapter = ContactAdapter(requireContext().applicationContext, updatedList)

            secondBinding.emptyContact.isVisible = updatedList.isEmpty()

            if (recyclerView.adapter != null) {
                contactAdapter.setContact(updatedList)
                recyclerView.adapter = contactAdapter

            } else {
                recyclerView.adapter = contactAdapter
            }
        }

        return secondBinding.root
    }


}


