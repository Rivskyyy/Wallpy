package com.RivskyInc.wallpy.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.RivskyInc.wallpy.Repository.WallpaperRepository

class WallpaperViewModelFactory(private val wallpaperRepository: WallpaperRepository)
: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return com.RivskyInc.wallpy.ViewModelFactory.ViewModel(wallpaperRepository) as T
    }

}