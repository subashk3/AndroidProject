package com.example.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.item_card_view.view.*

class ItemAdapter(private val context: Context, private val items: ArrayList<String>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    //Set ViewHolder
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val itemViewId: TextView = view.text_item
        val cardView: CardView = view.card_view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_card_view, parent, false)
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemViewId.text = item
      if (position % 2 != 0) {
            holder.cardView.setBackgroundColor(ContextCompat.getColor(context, R.color.whiteBlack))
        } else {
            holder.cardView.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}