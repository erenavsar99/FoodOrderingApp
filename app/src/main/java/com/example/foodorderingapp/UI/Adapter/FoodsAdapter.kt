package com.example.foodorderingapp.UI.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.Data.Entity.FoodList
import com.example.foodorderingapp.R
import com.example.foodorderingapp.UI.Fragments.FoodListingFragment
import com.example.foodorderingapp.UI.Fragments.FoodListingFragmentDirections
import com.example.foodorderingapp.UI.viewModels.FoodListingFragmentViewModel
import com.example.foodorderingapp.Util.switch
import com.example.foodorderingapp.databinding.ItemViewBinding
import com.google.android.material.snackbar.Snackbar

class FoodsAdapter (var mContext: Context,
                    var foodList: List<FoodList>,
                    var viewModel: FoodListingFragmentViewModel)
    : RecyclerView.Adapter<FoodsAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim:ItemViewBinding) : RecyclerView.ViewHolder(tasarim.root) {
        var tasarim:ItemViewBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim:ItemViewBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_view, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val food = foodList.get(position)
        val t = holder.tasarim
        t.foodItem = food

        t.cardItem.setOnClickListener {
            val switchTo = FoodListingFragmentDirections.toFoodDetailFragment(foodItem = food)
            Navigation.switch(it,switchTo)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}

