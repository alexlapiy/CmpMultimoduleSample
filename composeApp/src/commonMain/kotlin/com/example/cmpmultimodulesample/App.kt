package com.example.cmpmultimodulesample

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.cmpmultimodulesample.navigation.AppNavHost
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    MaterialTheme {
        AppNavHost()
    }
}

@Preview
@Composable
fun AppPreview() {
    App()
}