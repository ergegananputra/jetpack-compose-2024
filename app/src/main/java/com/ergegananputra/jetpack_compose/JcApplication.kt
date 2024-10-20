package com.ergegananputra.jetpack_compose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class JcApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}