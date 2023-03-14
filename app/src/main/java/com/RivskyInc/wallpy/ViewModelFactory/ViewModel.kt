package com.RivskyInc.wallpy.ViewModelFactory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.RivskyInc.wallpy.API.WallpaperResponse
import com.RivskyInc.wallpy.Repository.WallpaperRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModel(val repository : WallpaperRepository) : ViewModel() {

    lateinit var wallpaperList : MutableLiveData<Response<WallpaperResponse>>


    init {
    wallpaperList = MutableLiveData()
    getWallpaper("nature hd")

    }

    fun getWallpaper(s : String){

        viewModelScope.launch {

            val response = repository.getWallpaper(s)

            wallpaperList.postValue(response)

        }
    }
}