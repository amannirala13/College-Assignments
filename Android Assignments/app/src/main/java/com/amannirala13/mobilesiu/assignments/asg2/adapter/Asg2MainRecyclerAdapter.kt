package com.amannirala13.mobilesiu.assignments.asg2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amannirala13.mobilesiu.R
import com.amannirala13.mobilesiu.assignments.asg2.models.Restaurant

class Asg2MainRecyclerAdapter(var context: Context, var restaurantList: MutableList<Restaurant>): RecyclerView.Adapter<Asg2MainRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_asg2_main_recycler_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.restTitleText.text  = restaurantList[position].name
        holder.restAddressText.text = restaurantList[position].address
        holder.restSpecialText.text = restaurantList[position].special
        val rating = "${restaurantList[position].rating}/5.0"
        holder.restRatingText.text = rating
    }

    override fun getItemCount(): Int {
        return restaurantList.count()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val restTitleText: TextView = itemView.findViewById(R.id.card_asg2_main_title_text)
        val restAddressText: TextView = itemView.findViewById(R.id.card_asg2_address_text)
        val restSpecialText: TextView = itemView.findViewById(R.id.card_asg2_special_item_text)
        val restRatingText: TextView = itemView.findViewById(R.id.card_asg2_rate_text)
    }
}