package com.RivskyInc.wallpy.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.RivskyInc.wallpy.API.Photo
import com.RivskyInc.wallpy.Adapter.Adapter
import com.RivskyInc.wallpy.FilterSearch
import com.RivskyInc.wallpy.MainActivity
import com.RivskyInc.wallpy.Repository.WallpaperRepository
import com.RivskyInc.wallpy.ViewModelFactory.ViewModel
import com.RivskyInc.wallpy.ViewModelFactory.WallpaperViewModelFactory
import com.RivskyInc.wallpy.WallpaperDetailActivity
import com.RivskyInc.wallpy.databinding.FragmentHomeBinding
import com.bumptech.glide.request.ErrorRequestCoordinator
import java.util.Locale.filter


class HomeFragment : Fragment(), FilterSearch {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: ViewModel
    private lateinit var wallAdapter: Adapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)


        binding.buttonSearch.setOnClickListener {

            var searched = binding.editTextSearch.text.toString().lowercase()

            if (filter(searched) == true  ) {
                viewModel.getWallpaper(searched)
            } else {

                viewModel.getWallpaper("wallpapers hd")

            }

        }

        val repository = WallpaperRepository()
        val viewModelFactory = WallpaperViewModelFactory(repository)

        viewModel =
            ViewModelProvider(this@HomeFragment, viewModelFactory)[ViewModel::class.java]
        viewModel.getWallpaper(" wallpapers hd")

        setupRecyclerView()

//        viewModel.wallpaperList.observe(viewLifecycleOwner, Observer {
//            if ( it.isSuccessful){
//                val response = it.body()
//                wallAdapter.setWallpaperData(response?.photo as ArrayList<Photo>,
//                    this@HomeFragment.requireContext())
//            }
//        })

        viewModel.wallpaperList.observe(viewLifecycleOwner, Observer {

            if (it.isSuccessful) {
                val response = it.body()
                if (response != null) {
                    wallAdapter.setWallpaperData(
                        response.photos as ArrayList<Photo>,
                        this.requireContext()
                    )

                }
            }
        })


        return binding.root


    }

    private fun setupRecyclerView() {

        wallAdapter = Adapter()

        binding.recyclerView.apply {

            adapter = wallAdapter
            layoutManager = GridLayoutManager(this@HomeFragment.context, 2)

        }

    }


}
