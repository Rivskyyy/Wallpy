package com.RivskyInc.wallpy.API

import retrofit2.Response

interface Api {

    suspend fun getWallpapers(




    ) : Response<WallpaperResponse>
}