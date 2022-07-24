package com.example.foodorderingapp.UI.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderingapp.Data.Entity.FoodList
import com.example.foodorderingapp.Data.Repository.FoodListDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FoodListingFragmentViewModel @Inject constructor (var krepo: FoodListDaoRepository) : ViewModel() {
    var foodList = MutableLiveData<List<FoodList>>()

    init {
        foodList = krepo.toFoodList()
    }

    fun getEveryItem(){
        krepo.getAllFoods()
    }

}