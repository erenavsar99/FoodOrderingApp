package com.example.foodorderingapp.UI.viewModels

import androidx.lifecycle.ViewModel
import com.example.foodorderingapp.Data.Repository.FoodListDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnCartFragmentViewModel @Inject constructor (var krepo: FoodListDaoRepository) : ViewModel() {

    fun getFoodsToCart(kullanici_adi:String){
        krepo.saveCart(kullanici_adi)
    }

    fun deleteFromCart(kullanici_adi: String, sepet_yemek_id:Int){
        krepo.deleteCart(kullanici_adi, sepet_yemek_id)
    }
}