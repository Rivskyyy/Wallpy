package com.RivskyInc.wallpy.fragments

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
import com.RivskyInc.wallpy.Repository.WallpaperRepository
import com.RivskyInc.wallpy.ViewModelFactory.ViewModel
import com.RivskyInc.wallpy.ViewModelFactory.WallpaperViewModelFactory
import com.RivskyInc.wallpy.databinding.FragmentPopularBinding


class PopularFragment : Fragment() {

    private lateinit var binding: FragmentPopularBinding
    private lateinit var viewModel: ViewModel
    private lateinit var wallAdapter: Adapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
    try{



        binding = FragmentPopularBinding.inflate(layoutInflater, container, false)

        val repository = WallpaperRepository()
        val viewModelFactory = WallpaperViewModelFactory(repository)

        viewModel =
            ViewModelProvider(this@PopularFragment, viewModelFactory)[ViewModel::class.java]
        setupRecyclerView()

        viewModel.getWallpaper("4k wallpapers")




//        viewModel.wallpaperList.observe(viewLifecycleOwner, Observer {
//            if ( it.isSuccessful){
//                val response = it.body()
//                wallAdapter.setWallpaperData(response?.photo as ArrayList<Photo>,
//                    this@HomeFragment.requireContext())
//            }
//        })
        try {

            viewModel.wallpaperList.observe(viewLifecycleOwner, Observer {

                if (it.isSuccessful) {
                    val response = it.body()

                    if (response != null) {
                        wallAdapter.setWallpaperData(
                            response.photos as ArrayList<Photo>,this.requireContext()
                        )
                    }

                } else if (!it.isSuccessful) {
                    Log.d("My Tag", it.toString())
                    Toast.makeText(this.requireContext(), "Please, check your internet connection", Toast.LENGTH_LONG).show()
                }
            })


        } catch (e: java.lang.NullPointerException) {
            Log.d("Error", "Null ")
        }

    } catch (e : java.lang.NullPointerException ){

        Toast.makeText(this.requireContext(), "Please, check your internet connection", Toast.LENGTH_LONG).show()
    }
        return binding.root


    }

    private fun setupRecyclerView() {

        wallAdapter = Adapter()

        binding.recyclerViewPopular.apply {

            adapter = wallAdapter
            layoutManager = GridLayoutManager(this@PopularFragment.context, 2)


        }
    }
    }

