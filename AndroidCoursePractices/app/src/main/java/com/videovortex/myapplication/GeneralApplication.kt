package com.videovortex.myapplication

import android.app.Application
import timber.log.Timber

class GeneralApplication : Application() {

    //TODO clase para inicializar todo antes de cualquier activity
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}