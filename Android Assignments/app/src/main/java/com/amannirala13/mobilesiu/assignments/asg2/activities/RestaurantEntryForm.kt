package com.amannirala13.mobilesiu.assignments.asg2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import com.amannirala13.mobilesiu.R
import com.amannirala13.mobilesiu.assignments.asg2.models.Restaurant
import com.amannirala13.mobilesiu.assignments.asg2.models.RestaurantListViewModel
import com.amannirala13.mobilesiu.assignments.asg2.models.restViewModel
import kotlinx.android.synthetic.main.activity_restaurant_entry_form.*

class RestaurantEntryForm : AppCompatActivity(), LifecycleOwner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_entry_form)

        rest_entry_done_btn.setOnClickListener{
            restViewModel?.addRestaurant(Restaurant((restViewModel!!.restaurantList().value?.count()?:0).toString(),
                rest_entry_name_text.text.toString(),
                rest_entry_address_text.text.toString(),
                rest_entry_rating_text.text.toString(),
                rest_entry_special_text.text.toString()
            ))
            finish()
        }
    }
}