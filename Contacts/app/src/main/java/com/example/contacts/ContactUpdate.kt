package com.example.contacts


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.contacts.database.Contact
import com.example.contacts.database.ContactDataBase
import com.example.contacts.databinding.FragmentContactUpdateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


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
    ): View {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contact_update, container, false)

//Save the Contact
        binding.saveContact.setOnClickListener {
            isValidContact()
        }
        return binding.root
    }

    private fun isValidContact() {
        val name = binding.userName.text.toString()
        val mobile = binding.mobileNumber.text.toString()
        val email = binding.email.text.toString()
        if (name.isNotEmpty() && mobile.isNotEmpty()) {
            if (mobile.length > 10 || mobile.length < 10) {
                Toast.makeText(context, "Mobile number should be 10 Count", Toast.LENGTH_SHORT)
                    .show()
            } else if ((android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                    .matches() && email.isNotEmpty())
            ) {
                Toast.makeText(context, "Invalid Email", Toast.LENGTH_SHORT)
                    .show()
            } else {
                insertUser(name, mobile, email)
            }

        } else {
            Toast.makeText(context, "Invalid Email", Toast.LENGTH_SHORT)
                .show()
        }

    }

    private fun insertUser(name: String, mobile: String, email: String) {

        val user = Contact(0, name, mobile, email)
        CoroutineScope(Dispatchers.IO).launch {
            val contactDao =
                ContactDataBase.getInstance(requireContext() as MainActivity)?.contactDao()
            contactDao?.insert(user)
            withContext(Dispatchers.Main) {
                activity?.onBackPressed()
                // Toast.makeText(context, "Added Successfully :)", Toast.LENGTH_SHORT).show()
                //  Snackbar.make(view, "Added Successfully :)", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDetach() { // detach the fragment
        super.onDetach()
        (requireActivity() as MainActivity).apply {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            invalidateOptionsMenu()
        }
    }

}