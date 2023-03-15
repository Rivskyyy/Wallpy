package com.RivskyInc.wallpy.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.RivskyInc.wallpy.R
import com.RivskyInc.wallpy.databinding.FragmentMainBinding
import com.RivskyInc.wallpy.fragments.Adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    private val tabTitles = listOf("Home", "Popular", "Categories")
    private val fragments= listOf(HomeFragment(), PopularFragment(), CategoryFragment())
private lateinit var binding : FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

            binding = FragmentMainBinding.inflate(layoutInflater, container, false)
            initViewPager()

            initTabLayout()
            initToolBar()

        return binding.root
    }

    private fun initTabLayout(){
        TabLayoutMediator(binding.tableLayout, binding.viewPager){ tab, position ->
            tab.text = tabTitles[position]

        }.attach()
    }

    private fun initViewPager(){
        val pagerAdapter = ViewPagerAdapter(context as FragmentActivity, fragments)
        binding.viewPager.adapter = pagerAdapter
        binding.viewPager.isUserInputEnabled = false

    }

    private fun initToolBar(){
        binding.toolbar.title = "Wallpy"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
    }
}