package com.example.foodorderingapp.Data.Entity

import com.google.gson.annotations.SerializedName

data class FoodListResponse(@SerializedName("yemekler") var yemekler:List<FoodList>, @SerializedName("success") var success:Int) {
}