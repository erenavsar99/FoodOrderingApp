package com.example.foodorderingapp.UI.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderingapp.Data.Entity.FoodList
import com.example.foodorderingapp.Data.Repository.FoodListDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FoodDetailFragmentViewModel @Inject constructor (var krepo:FoodListDaoRepository) : ViewModel() {
    fun sendToCart(yemek_adi:String, yemek_resim_adi:String, yemek_fiyat:Int, yemek_siparis_adet:Int, kullanici_adi:String){
        krepo.addToCart(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)
    }
}