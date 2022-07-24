package com.example.foodorderingapp.Retrofit

import com.example.foodorderingapp.Data.Entity.CRUDresponse
import com.example.foodorderingapp.Data.Entity.FoodListResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodListDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    @GET("yemekler/tumYemekleriGetir.php")
    fun allFoods() : Call<FoodListResponse>

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun addToCart(@Field ("yemek_adi") yemek_adi:String,
                  @Field ("yemek_resim_adi") yemek_resim_adi:String,
                  @Field ("yemek_fiyat") yemek_fiyat:Int,
                  @Field ("yemek_siparis_adet") yemek_siparis_adet:Int,
                  @Field ("kullanici_adi") kullanici_adi:String) : Call<CRUDresponse>


    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun saveCart(@Field ("kullanici_adi") kullanici_adi:String) : Call<CRUDresponse>


    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun deleteCart(@Field ("kullanici_adi") kullanici_adi: String,
                   @Field ("sepet_yemek_id") sepet_yemek_id: Int
    ) : Call<CRUDresponse>
}