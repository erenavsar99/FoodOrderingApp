package com.example.foodorderingapp.Data.Entity

import com.google.gson.annotations.SerializedName

data class CRUDresponse(@SerializedName("success") var success:Int,
                        @SerializedName("message") var message:String){
}
