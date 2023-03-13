package com.RivskyInc.wallpy.API

import com.RivskyInc.wallpy.Utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class RetrofitInstance {

    companion object{

        val retrofitFactory : Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val apiService= retrofitFactory.create(Api::class.java)
    }
}