package com.adl.ijin

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.adl.ijin.background.LocationServices
import kotlinx.android.synthetic.main.activity_location_service.*

class LocationServicesAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_service)

        if(!checkPermission()){

            requestPermission()
        }

        btnService.setOnClickListener({
            ContextCompat.startForegroundService(this, Intent(this, LocationServices::class.java))
        })
        btnStop.setOnClickListener({
            stopService(Intent(this,LocationServices::class.java))
        })
    }


    fun checkPermission():Boolean{
        val fineLocationCheck = ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.ACCESS_FINE_LOCATION)
        val fineCoarseLocation = ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.ACCESS_COARSE_LOCATION)

        return fineLocationCheck == PackageManager.PERMISSION_GRANTED && fineCoarseLocation == PackageManager.PERMISSION_GRANTED
    }

    fun requestPermission(){
        ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION),1)
    }
}