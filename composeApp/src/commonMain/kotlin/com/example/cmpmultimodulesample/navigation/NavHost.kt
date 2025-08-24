package com.example.cmpmultimodulesample.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.character.presentation.CharactersScreen
import com.example.location.presentation.location.LocationScreen

object NavigationState {
    val selectedResidentUrls = mutableStateOf<List<String>>(emptyList())
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "locationList") {
        composable("locationList") {
            LocationScreen(
                onLocationClick = { location ->
                    NavigationState.selectedResidentUrls.value = location.residents
                    navController.navigate("characters")
                }
            )
        }
        composable("characters") {
            val residentUrls = remember { NavigationState.selectedResidentUrls.value }
            CharactersScreen(residentUrls = residentUrls)
        }
    }
}