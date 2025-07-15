package com.example.cmpmultimodulesample

import android.app.Application
import com.example.cmpmultimodulesample.di.initializeKoin
import org.koin.android.ext.koin.androidContext

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeKoin {
            androidContext(this@SampleApplication)
        }
    }
}