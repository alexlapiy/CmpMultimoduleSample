package com.example.cmpmultimodulesample

import android.app.Application
import com.example.cmpmultimodulesample.di.initializeKoin
import com.example.core.utils.initDebugLogger
import org.koin.android.ext.koin.androidContext

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initDebugLogger()

        initializeKoin {
            androidContext(this@SampleApplication)
        }
    }
}