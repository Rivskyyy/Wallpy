package com.RivskyInc.wallpy.API

import com.RivskyInc.wallpy.API_KEY.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {

    @Headers(API_KEY)
    @GET("search")
    suspend fun getWallpapers(

        @Query("query")
        query : String = " nature",
        @Query("per_page") per_page : Int = 80

    ) : Response<WallpaperResponse>
}