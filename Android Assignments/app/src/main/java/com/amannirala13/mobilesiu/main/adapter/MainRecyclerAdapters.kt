package com.amannirala13.mobilesiu.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.amannirala13.mobilesiu.R
import com.amannirala13.mobilesiu.main.model.Assignment

class MainRecyclerAdapters(private var context: Context, private var assignmentList: List<Assignment>):  RecyclerView.Adapter<MainRecyclerAdapters.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_assignment_container, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.assignmentTitleText.text = assignmentList[position].title
        holder.assignmentDescriptionText.text = assignmentList[position].description
    }

    override fun getItemCount(): Int {
        return assignmentList.count()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var assignmentTitleText: TextView = itemView.findViewById(R.id.assignment_title_text)
        var assignmentDescriptionText: TextView = itemView.findViewById(R.id.assignment_description_text)
    }
}