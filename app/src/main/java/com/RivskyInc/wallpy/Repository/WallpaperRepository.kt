package com.RivskyInc.wallpy.Repository

import com.RivskyInc.wallpy.API.RetrofitInstance

class WallpaperRepository {

    suspend fun  getWallpaper(query : String) = RetrofitInstance.apiService.getWallpapers(query)

}