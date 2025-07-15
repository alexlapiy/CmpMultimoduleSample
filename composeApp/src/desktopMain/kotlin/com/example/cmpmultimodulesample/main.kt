package com.example.cmpmultimodulesample

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.cmpmultimodulesample.di.initializeKoin

fun main() = application {

    initializeKoin()

    Window(
        onCloseRequest = ::exitApplication,
        title = "CmpMultimoduleSample",
    ) {
        App()
    }
}