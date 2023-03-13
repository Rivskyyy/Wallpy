package com.RivskyInc.wallpy.API

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {

    @Headers()
    @GET("search")
    suspend fun getWallpapers(

        @Query("query")
        query : String = " nature",
        @Query("per_page") per_page : Int = 80

    ) : Response<WallpaperResponse>
}