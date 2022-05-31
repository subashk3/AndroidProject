package com.example.contacts.util

import androidx.recyclerview.widget.DiffUtil
import com.example.contacts.database.Contact

class ContactUtil(private var oldList: List<Contact>, private var newList: List<Contact>) :
    DiffUtil.Callback() {


    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

        return oldList[oldItemPosition].id === newList[newItemPosition].id

    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        when {
            oldList[oldItemPosition].id != newList[newItemPosition].id -> {
                return false
            }
            oldList[oldItemPosition].userName != newList[newItemPosition].userName -> {
                return false
            }
            oldList[oldItemPosition].mobileNumber != newList[newItemPosition].mobileNumber -> {
                return false
            }

            oldList[oldItemPosition].email != newList[newItemPosition].email -> {
                return false
            }
        }
        return true
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}