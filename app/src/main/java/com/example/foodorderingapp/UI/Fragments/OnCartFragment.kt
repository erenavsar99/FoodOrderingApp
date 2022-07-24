package com.example.foodorderingapp.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.foodorderingapp.R
import com.example.foodorderingapp.UI.viewModels.FoodDetailFragmentViewModel
import com.example.foodorderingapp.UI.viewModels.FoodListingFragmentViewModel
import com.example.foodorderingapp.UI.viewModels.OnCartFragmentViewModel
import com.example.foodorderingapp.databinding.FragmentOnCartBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnCartFragment : Fragment() {
    private lateinit var tasarim: FragmentOnCartBinding
    private lateinit var  viewModel: OnCartFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_on_cart, container, false)
        tasarim.onCartFragment = this
        tasarim.onCartToolbar = "Cart"

        tasarim.buttonBuy.setOnClickListener(){
            Snackbar.make(it, "Your Order Has Been Received", Snackbar.LENGTH_LONG)
        }

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: OnCartFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun getFoods(kullanici_adi:String){
        viewModel.getFoodsToCart(kullanici_adi)
    }

    fun deleteFoods(kullanici_adi: String = "eren_avsar", sepet_yemek_id:Int = 1){
        viewModel.deleteFromCart(kullanici_adi, sepet_yemek_id)
    }

    override fun onResume() {
        super.onResume()
    }
}