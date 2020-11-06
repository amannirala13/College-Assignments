package com.amannirala13.mobilesiu.assignments.asg2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amannirala13.mobilesiu.R
import com.amannirala13.mobilesiu.assignments.asg2.adapter.Asg2MainRecyclerAdapter
import com.amannirala13.mobilesiu.assignments.asg2.models.Restaurant
import com.amannirala13.mobilesiu.assignments.asg2.models.RestaurantListViewModel
import com.amannirala13.mobilesiu.assignments.asg2.models.restViewModel
import com.amannirala13.mobilesiu.main.tools.RecyclerTouchListener
import kotlinx.android.synthetic.main.activity_asg2_main.*
import kotlinx.android.synthetic.main.activity_main.*

class Asg2MainActivity : AppCompatActivity(), LifecycleOwner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asg2_main)

        if(restViewModel==null)
            restViewModel = ViewModelProvider(this).get(RestaurantListViewModel::class.java)

        asg2_main_add_btn.setOnClickListener{
            startActivity(Intent(this, RestaurantEntryForm::class.java))
        }

        addAdapter(restViewModel!!.restaurantList().value?:mutableListOf())

        restViewModel!!.restaurantList().observe(this, {
            addAdapter(it)
        })
    }

    private fun addAdapter(it: MutableList<Restaurant>){
        asg2_main_recycler.apply {
            setHasFixedSize(true)
            val linearLayoutManagerForFeaturedRecycler=  LinearLayoutManager(context)
            linearLayoutManagerForFeaturedRecycler.orientation = RecyclerView.VERTICAL
            layoutManager = linearLayoutManagerForFeaturedRecycler
            adapter = Asg2MainRecyclerAdapter(this@Asg2MainActivity,it)
            addOnItemTouchListener(
                RecyclerTouchListener(context, asg2_main_recycler,
                    object: RecyclerTouchListener.ClickListener{
                        override fun onClick(view: View?, position: Int) {
                        }
                        override fun onLongClick(view: View?, position: Int) {} })) }
    }
}