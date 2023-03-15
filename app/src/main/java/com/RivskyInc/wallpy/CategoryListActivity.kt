package com.RivskyInc.wallpy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.RivskyInc.wallpy.API.Photo
import com.RivskyInc.wallpy.Adapter.Adapter
import com.RivskyInc.wallpy.Repository.WallpaperRepository
import com.RivskyInc.wallpy.ViewModelFactory.ViewModel
import com.RivskyInc.wallpy.ViewModelFactory.WallpaperViewModelFactory
import com.RivskyInc.wallpy.databinding.ActivityCategoryListBinding

class CategoryListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCategoryListBinding
    private lateinit var viewModel: ViewModel
    private lateinit var wallAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryListBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val repository = WallpaperRepository()
        val viewModelFactory = WallpaperViewModelFactory(repository)

        viewModel =
            ViewModelProvider(this, viewModelFactory)[ViewModel::class.java]
        setupRecyclerView()

        val getCategory = intent.getStringExtra("category")

        if (getCategory != null) {
            viewModel.getWallpaper(getCategory)
        }




//        viewModel.wallpaperList.observe(viewLifecycleOwner, Observer {
//            if ( it.isSuccessful){
//                val response = it.body()
//                wallAdapter.setWallpaperData(response?.photo as ArrayList<Photo>,
//                    this@HomeFragment.requireContext())
//            }
//        })
        try {

            viewModel.wallpaperList.observe(this, Observer {

                if (it.isSuccessful) {
                    val response = it.body()

                    if (response != null) {
                        wallAdapter.setWallpaperData(
                            response.photos as ArrayList<Photo>,this@CategoryListActivity
                        )
                    }

                }
            })


        } catch (e: java.lang.NullPointerException) {
            Log.d("Error", "Null ")
        }





    }

private fun setupRecyclerView() {

    wallAdapter = Adapter()

    binding.recyclerViewCategoryList.apply {

        adapter = wallAdapter
        layoutManager = GridLayoutManager(this@CategoryListActivity, 2)


    }
}
}
