package com.amannirala13.mobilesiu.main.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amannirala13.mobilesiu.R
import com.amannirala13.mobilesiu.assignments.asg1.Asg1First
import com.amannirala13.mobilesiu.assignments.asg2.activities.Asg2MainActivity
import com.amannirala13.mobilesiu.main.adapter.MainRecyclerAdapters
import com.amannirala13.mobilesiu.main.model.Assignment
import com.amannirala13.mobilesiu.main.model.AssignmentRunnable
import com.amannirala13.mobilesiu.main.tools.RecyclerTouchListener
import kotlinx.android.synthetic.main.activity_main.*

private var assignmentList: MutableList<Assignment> = mutableListOf()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addAssignments()

    }

    private fun addAssignments(){

        assignmentList.add(Assignment(1, "Assignment 1", "This assignment is about passing a text from one activity another via intent!", "Aman Kumar Nirala",
            object: AssignmentRunnable{ override fun execute() { startActivity(Intent(this@MainActivity, Asg1First::class.java)) } }))

        assignmentList.add(Assignment(2, "Live Data (Assignment 2)", "This assignment is about using live data with view models and tools like recycler views", "Aman Kumar Nirala",
            object: AssignmentRunnable{ override fun execute() { startActivity(Intent(this@MainActivity, Asg2MainActivity::class.java)) } }))

        if(assignmentList.isNotEmpty())
            addAdapter()
    }

    private fun addAdapter() {
        main_assignment_recycler.apply{
            setHasFixedSize(true)
            val linearLayoutManagerForFeaturedRecycler=  LinearLayoutManager(context)
            linearLayoutManagerForFeaturedRecycler.orientation = RecyclerView.VERTICAL
            layoutManager = linearLayoutManagerForFeaturedRecycler
            adapter = MainRecyclerAdapters(context, assignmentList)
            addOnItemTouchListener(RecyclerTouchListener(context, main_assignment_recycler,
                object: RecyclerTouchListener.ClickListener{
                    override fun onClick(view: View?, position: Int) {
                        assignmentList[position].runnable.execute() }
                    override fun onLongClick(view: View?, position: Int) {
                        Toast.makeText(this@MainActivity, "Author: ${assignmentList[position].author}",Toast.LENGTH_SHORT).show() } }))
        }
    }


}