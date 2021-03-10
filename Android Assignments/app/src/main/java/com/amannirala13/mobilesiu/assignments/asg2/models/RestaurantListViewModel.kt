package com.amannirala13.mobilesiu.assignments.asg2.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RestaurantListViewModel: ViewModel(){

    private var _restaurantList = MutableLiveData<MutableList<Restaurant>>()

    fun restaurantList() = _restaurantList

    fun addRestaurant(item: Restaurant){
        val temp = _restaurantList.value?: mutableListOf()
        temp.add(item)
        _restaurantList.value = temp
    }

    fun deleteRestaurant(index: Int){
        val temp = _restaurantList.value?: mutableListOf()
        temp.removeAt(index)
        _restaurantList.value = temp
    }
}