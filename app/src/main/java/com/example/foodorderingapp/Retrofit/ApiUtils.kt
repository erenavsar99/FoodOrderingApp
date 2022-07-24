package com.example.foodorderingapp.Retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getFoodListDao() : FoodListDao {
            return RetrofitClient.getClient(BASE_URL).create(FoodListDao::class.java)
        }
    }


}