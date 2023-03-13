package com.RivskyInc.wallpy.API

data class WallpaperResponse(

    val next_page: String,
    val page: Int,
    val per_page: Int,
    val prev_page: String,
    val photos : List<Photo>,
    val total_results: Int

)
