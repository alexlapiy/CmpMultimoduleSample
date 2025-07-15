package com.example.cmpmultimodulesample

import androidx.compose.ui.window.ComposeUIViewController
import com.example.cmpmultimodulesample.di.initializeKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initializeKoin()
    }
) { App() }