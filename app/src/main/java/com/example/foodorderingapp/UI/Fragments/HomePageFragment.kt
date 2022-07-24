package com.example.foodorderingapp.UI.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.foodorderingapp.R
import com.example.foodorderingapp.databinding.FragmentHomePageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : Fragment() {
    private lateinit var tasarim:FragmentHomePageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false)
        tasarim.homePageFragment = this


        tasarim.buttonLogin.setOnClickListener(){
            Navigation.findNavController(it).navigate(R.id.toFoodListingFragment)
        }

        return tasarim.root
    }

    fun buttonLogin(kullanici_adi:String = "eren_avsar"){
        Log.e("Login", "$kullanici_adi")

    }
}
