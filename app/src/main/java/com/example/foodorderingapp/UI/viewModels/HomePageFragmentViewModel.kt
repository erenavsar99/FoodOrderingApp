package com.example.foodorderingapp.UI.viewModels

import androidx.lifecycle.ViewModel
import com.example.foodorderingapp.Data.Repository.FoodListDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomePageFragmentViewModel @Inject constructor (var krepo: FoodListDaoRepository) : ViewModel() {
    /*     implementation "anroidx.lifecycle:lifecycle-viewmodel:2.3.0"
    implementation "anroidx.activity:activity-ktx:1.2.0"*/
}