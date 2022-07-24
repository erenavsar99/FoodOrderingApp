package com.example.foodorderingapp.UI.Fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.R
import com.example.foodorderingapp.UI.Adapter.FoodsAdapter
import com.example.foodorderingapp.UI.viewModels.FoodListingFragmentViewModel
import com.example.foodorderingapp.databinding.FragmentFoodListingBinding
import com.example.foodorderingapp.Data.Entity.FoodList
import com.example.foodorderingapp.Util.switch
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodListingFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var tasarim:FragmentFoodListingBinding
    private lateinit var viewModel:FoodListingFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_food_listing, container, false)
        tasarim.foodListingFragment = this
        tasarim.foodListingToolbar = "Foods"

        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarListing)

        viewModel.foodList.observe(viewLifecycleOwner){
            val adapter = FoodsAdapter(requireContext(), it, viewModel)
            tasarim.foodsAdapter = adapter
        }


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel:FoodListingFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu.findItem(R.id.action_search)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.getEveryItem()
    }
}