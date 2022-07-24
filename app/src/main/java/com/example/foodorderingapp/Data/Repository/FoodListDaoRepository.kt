package com.example.foodorderingapp.Data.Repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.foodorderingapp.Data.Entity.CRUDresponse
import com.example.foodorderingapp.Data.Entity.FoodList
import com.example.foodorderingapp.Data.Entity.FoodListResponse
import com.example.foodorderingapp.Retrofit.FoodListDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodListDaoRepository(var kdao:FoodListDao) {
    var foodList:MutableLiveData<List<FoodList>>

    init {
        foodList = MutableLiveData()
    }

    fun toFoodList() : MutableLiveData<List<FoodList>>{
        return foodList
    }


    fun addToCart(yemek_adi:String, yemek_resim_adi:String, yemek_fiyat:Int, yemek_siparis_adet:Int, kullanici_adi:String){
        kdao.addToCart(yemek_adi, yemek_resim_adi, yemek_siparis_adet, yemek_fiyat, kullanici_adi).enqueue(object : Callback<CRUDresponse>{
            override fun onResponse(
                call: Call<CRUDresponse>?, response: Response<CRUDresponse>?) {
                val success = response?.body()?.success
                val message = response?.body()?.message
                Log.e("Sepete Ekle", "$success - $message")
            }

            override fun onFailure(call: Call<CRUDresponse>?, t: Throwable?) {

            }
        })
    }

    fun saveCart(kullanici_adi: String){
        kdao.saveCart(kullanici_adi).enqueue(object : Callback<CRUDresponse>{
            override fun onResponse(
                call: Call<CRUDresponse>?, response: Response<CRUDresponse>?) {
                val success = response?.body()?.success
                val message = response?.body()?.message
                Log.e("Sepeti Kaydet", "$success - $message")
            }

            override fun onFailure(call: Call<CRUDresponse>?, t: Throwable?) {

            }
        })
    }

    fun deleteCart(kullanici_adi: String, sepet_yemek_id: Int){
        kdao.deleteCart(kullanici_adi, sepet_yemek_id).enqueue(object : Callback<CRUDresponse>{
            override fun onResponse(
                call: Call<CRUDresponse>?, response: Response<CRUDresponse>?) {
                val success = response?.body()?.success
                val message = response?.body()?.message
                Log.e("Sepetten Çıkar", "$success - $message")
            }

            override fun onFailure(call: Call<CRUDresponse>?, t: Throwable?) {

            }
        })
    }

    fun getAllFoods(){
        kdao.allFoods().enqueue(object:Callback<FoodListResponse>{
            override fun onResponse(
                call: Call<FoodListResponse>?, response: Response<FoodListResponse>) {
                val list = response.body().yemekler
                foodList.value = list

            }
            override fun onFailure(call: Call<FoodListResponse>?, t: Throwable?) {

            }
        })
    }
}