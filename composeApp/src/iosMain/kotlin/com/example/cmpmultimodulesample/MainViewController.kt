package com.example.cmpmultimodulesample

import androidx.compose.ui.window.ComposeUIViewController
import com.example.cmpmultimodulesample.di.initializeKoin
import com.example.core.utils.initDebugLogger

fun MainViewController() = ComposeUIViewController(
    configure = {
        initDebugLogger()
        initializeKoin()
    }
) { App() }