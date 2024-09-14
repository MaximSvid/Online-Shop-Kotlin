package com.example.onlineshopprojectkotlin.Fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.onlineshopprojectkotlin.Adapter.CategoriesAdapter
import com.example.onlineshopprojectkotlin.Adapter.RecommendationAdapter
import com.example.onlineshopprojectkotlin.Adapter.SalesAdapter
import com.example.onlineshopprojectkotlin.Adapter.ViewPager2AdapterHome
import com.example.onlineshopprojectkotlin.ViewModel.HomeViewModel
import com.example.onlineshopprojectkotlin.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewMode: HomeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        viewMode.loadProducts()


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerViewRecommendation = binding.rvRecommendation
        recyclerViewRecommendation.layoutManager = GridLayoutManager(requireContext(), 2) //TODO Dieser LayoutManager wird verwendet, um zwei RecyclerViews in einer Reihe anzuordnen





        //ganz productsList
        viewMode.productsList.observe(viewLifecycleOwner) { products ->
            binding.rvRecommendation.adapter = RecommendationAdapter(products)
            binding.rvSales.adapter = SalesAdapter(products)
            binding.rvCategory.adapter = CategoriesAdapter(products)


        }

        //limited productsList
        viewMode.limitedProductsList.observe(viewLifecycleOwner) {limitedProducts ->
            binding.viewPager2Home.adapter = ViewPager2AdapterHome(limitedProducts)

            //dotsIndicator inizializierung
            val dotsIndicator = binding.dotIndicator
            if (limitedProducts.isNotEmpty()) {
                binding.dotIndicator.visibility = View.VISIBLE
                dotsIndicator.attachTo(binding.viewPager2Home)
            }
        }

        binding.apply {
            ivSearch.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSearchFragment())
            }
        }



    }





}