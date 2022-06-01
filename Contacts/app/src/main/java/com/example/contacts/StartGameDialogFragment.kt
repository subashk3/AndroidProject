package com.example.contacts

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class StartGameDialogFragment : DialogFragment() {
    val mainActivity = MainActivity()
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            // Use the Builder class for convenient dialog construction

            val builder = AlertDialog.Builder(it)

            builder.setMessage(R.string.dialog_start_game)
                .setPositiveButton(R.string.start,
                    DialogInterface.OnClickListener { dialog, id ->
                        // START THE GAME!
                        mainActivity.deleteAllContact()
                          Toast.makeText(context, "Delete Successfully", Toast.LENGTH_SHORT).show()

                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog


                    })

            // Create the AlertDialog object and return it

            builder.create()

        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
