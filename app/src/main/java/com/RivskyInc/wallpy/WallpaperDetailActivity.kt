package com.RivskyInc.wallpy

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.RivskyInc.wallpy.databinding.ActivityWallpaperDetailBinding
import com.bumptech.glide.Glide
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException


class WallpaperDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWallpaperDetailBinding
    private final var TAG = "WallpaperDetailActivity"
    private var mInterstitialAd: InterstitialAd? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWallpaperDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val url = intent.getStringExtra("URL")

        Glide.with(this).load(url).into(binding.photoView)

        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            "ca-app-pub-7124048404999597/5803715151",
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(TAG, adError.toString())
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d(TAG, "Ad was loaded.")
                    mInterstitialAd = interstitialAd
                }
            })

        contentCallBack()
        showAd()

        binding.buttonSetWallpaperLock.setOnClickListener {
            showAd()
            Toast.makeText(
                this@WallpaperDetailActivity,
                "Loading...", Toast.LENGTH_LONG
            ).show()

            GlobalScope.launch(Dispatchers.IO) {
                val displayMetrics = DisplayMetrics()
                windowManager.defaultDisplay.getMetrics(displayMetrics)

                val height = displayMetrics.heightPixels * 2
                val width = displayMetrics.widthPixels * 2
                var result: Bitmap = Picasso.get().load(url).get()


                var wallpManger = WallpaperManager.getInstance(this@WallpaperDetailActivity)
                wallpManger.suggestDesiredDimensions(height, width)
                val finHeigt = wallpManger.desiredMinimumHeight
                val finWidht = wallpManger.desiredMinimumWidth

                try {

                    val walp = Bitmap.createScaledBitmap(result, finHeigt, finWidht, true);

                    wallpManger.setBitmap(
                        walp,
                        null,
                        true,
                        WallpaperManager.FLAG_LOCK
                    )

                    // wallpManger.setBitmap(walp)

                    this@WallpaperDetailActivity.runOnUiThread(Runnable {
                        Toast.makeText(
                            this@WallpaperDetailActivity,
                            "Wallpapers changed successfully", Toast.LENGTH_SHORT
                        ).show()
                    })
                } catch (ex: IOException) {

                }

            }
        }

        binding.buttonSetWallpaper.setOnClickListener {
            showAd()
            Toast.makeText(
                this@WallpaperDetailActivity,
                "Loading...", Toast.LENGTH_LONG
            ).show()

            GlobalScope.launch(Dispatchers.IO) {
                val displayMetrics = DisplayMetrics()
                windowManager.defaultDisplay.getMetrics(displayMetrics)

                val height = displayMetrics.heightPixels * 3
                val width = displayMetrics.widthPixels * 3
                var result: Bitmap = Picasso.get().load(url).get()


                var wallpManger = WallpaperManager.getInstance(this@WallpaperDetailActivity)
                wallpManger.suggestDesiredDimensions(height, width)
                val finHeigt = wallpManger.desiredMinimumHeight
                val finWidht = wallpManger.desiredMinimumWidth

                try {

                    val walp = Bitmap.createScaledBitmap(result, finHeigt, finWidht, true);
                    //  wallpManger.setBitmap(result, null, true, WallpaperManager.FLAG_SYSTEM)

                    wallpManger.setBitmap(walp)

                    this@WallpaperDetailActivity.runOnUiThread(Runnable {
                        Toast.makeText(
                            this@WallpaperDetailActivity,
                            "Wallpapers changed successfully", Toast.LENGTH_SHORT
                        ).show()
                    })
                } catch (ex: IOException) {

                }

            }
        }


    }

    fun showAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.")
        }
    }

    private fun contentCallBack() {
        mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdClicked() {
                // Called when a click is recorded for an ad.
                Log.d(TAG, "Ad was clicked.")
            }

            override fun onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                Log.d(TAG, "Ad dismissed fullscreen content.")
                mInterstitialAd = null
            }

            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                // Called when ad fails to show.
                Log.e(TAG, "Ad failed to show fullscreen content.")
                mInterstitialAd = null
            }

            override fun onAdImpression() {
                // Called when an impression is recorded for an ad.
                Log.d(TAG, "Ad recorded an impression.")
            }

            override fun onAdShowedFullScreenContent() {
                // Called when ad is shown.
                Log.d(TAG, "Ad showed fullscreen content.")
            }
        }

    }
}