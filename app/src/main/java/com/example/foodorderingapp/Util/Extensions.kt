package com.example.foodorderingapp.Util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun switch(v:View,id:Int){
    Navigation.findNavController(v).navigate(id)
}

fun Navigation.switch(v:View,id:NavDirections){
    findNavController(v).navigate(id)
}