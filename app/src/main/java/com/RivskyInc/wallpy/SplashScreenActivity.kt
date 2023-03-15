package com.RivskyInc.wallpy

import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        val connected = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)!!
            .state == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)!!.state == NetworkInfo.State.CONNECTED

        Log.d("NETWORK", connected.toString())

        if ( connected== true ){
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Please, check your internet  and restart app.", Toast.LENGTH_LONG).show()
        }
    }
}