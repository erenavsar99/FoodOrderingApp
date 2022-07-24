package com.example.foodorderingapp.UI.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.foodorderingapp.R
import com.example.foodorderingapp.UI.viewModels.FoodDetailFragmentViewModel
import com.example.foodorderingapp.databinding.FragmentFoodDetailBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodDetailFragment : Fragment() {
    private lateinit var tasarim:FragmentFoodDetailBinding
    private lateinit var viewModel:FoodDetailFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_food_detail, container, false)
        tasarim.foodDetailFragment = this
        tasarim.foodDetailToolbar = "Order"

        val bundle:FoodDetailFragmentArgs by navArgs()
        val chosenItem = bundle.foodItem
        tasarim.foodItem = chosenItem

        val yemekFiyatInt = tasarim.textViewFoodNumber.toString().toInt() * tasarim.textViewFoodPrice.toString().toInt()

        val foodAmount = 1
        tasarim.textViewFoodNumber.text = foodAmount.toString()

        tasarim.imageButtonPlus.setOnClickListener(){
            tasarim.textViewFoodNumber.text =  (foodAmount + 1).toString()
        }

        tasarim.imageButtonMines.setOnClickListener(){
            if(foodAmount == 1)
                Snackbar.make(it, "Food amount cannot be lower more.", Snackbar.LENGTH_LONG)
            else
            tasarim.textViewFoodNumber.text =  (foodAmount - 1).toString()
        }

       tasarim.buttonAddToCart.setOnClickListener(){
            buttonAddToCart(yemek_adi = tasarim.textViewFoodName.text.toString(), yemek_fiyat = yemekFiyatInt, yemek_siparis_adet = tasarim.textViewFoodNumber.text.toString().toInt(), kullanici_adi = "eren_avsar", yemek_resim_adi = "ayran.png")
        }

        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:FoodDetailFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonAddToCart(yemek_adi:String, yemek_resim_adi:String, yemek_fiyat:Int, yemek_siparis_adet:Int, kullanici_adi:String = "eren_avsar"){

        viewModel.sendToCart(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)
    }
}
