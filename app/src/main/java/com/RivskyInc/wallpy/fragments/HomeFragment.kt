package com.RivskyInc.wallpy.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.RivskyInc.wallpy.Adapter.Adapter
import com.RivskyInc.wallpy.R
import com.RivskyInc.wallpy.Repository.WallpaperRepository
import com.RivskyInc.wallpy.ViewModelFactory.ViewModel
import com.RivskyInc.wallpy.ViewModelFactory.WallpaperViewModelFactory
import com.RivskyInc.wallpy.databinding.ActivityMainBinding
import com.RivskyInc.wallpy.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    lateinit var viewModel : ViewModel
    lateinit var adapter : Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  FragmentHomeBinding.inflate(layoutInflater, container, false )

        binding.buttonSearch.setOnClickListener {

            val searched = binding.editTextSearch.text.toString()
            viewModel.getWallpaper(searched)
        }

        val repository = WallpaperRepository()
        val viewModelFactory = WallpaperViewModelFactory(repository)

        viewModel = ViewModelProvider( this, viewModelFactory).get(ViewModel::class.java)

        setupRecyclerView()

        return binding.root


    }

    private fun setupRecyclerView() {

        adapter = Adapter()

        binding.recyclerView.apply {

            adapter = adapter
            layoutManager = GridLayoutManager(this@HomeFragment.context, 2)


        }
    }


}
