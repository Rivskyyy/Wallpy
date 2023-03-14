package com.RivskyInc.wallpy

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.RivskyInc.wallpy.databinding.ActivityWallpaperDetailBinding
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException


class WallpaperDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWallpaperDetailBinding

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWallpaperDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)



        val url = intent.getStringExtra("URL")

         Glide.with(this).load(url).into(binding.photoView)



        binding.buttonSetWallpaper.setOnClickListener {

            GlobalScope.launch(Dispatchers.IO){
                val displayMetrics = DisplayMetrics()
                windowManager.defaultDisplay.getMetrics(displayMetrics)

                val height = displayMetrics.heightPixels  * 4
                val width = displayMetrics.widthPixels  * 4
                var result : Bitmap = Picasso.get().load(url).get()


                var wallpManger = WallpaperManager.getInstance(this@WallpaperDetailActivity)
                wallpManger.suggestDesiredDimensions(height, width)
                val finHeigt = wallpManger.desiredMinimumHeight
                val finWidht  = wallpManger.desiredMinimumWidth

                try {



                    val walp   = Bitmap.createScaledBitmap(result , finHeigt, finWidht, true);
                  //  wallpManger.setBitmap(result, null, true, WallpaperManager.FLAG_SYSTEM)

                    wallpManger.setBitmap(walp)



                    this@WallpaperDetailActivity.runOnUiThread(Runnable {
                        Toast.makeText(this@WallpaperDetailActivity,
                            "Wallpapers changed successfully", Toast.LENGTH_SHORT).show()
                    })
                }catch (ex : IOException){

                }

            }
        }


    }

}