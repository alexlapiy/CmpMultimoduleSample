package com.example.cmpmultimodulesample.navigation

import androidx.compose.runtime.Composable
import com.composegears.tiamat.NavDestination
import com.composegears.tiamat.Navigation
import com.composegears.tiamat.navArgs
import com.composegears.tiamat.navController
import com.composegears.tiamat.navDestination
import com.composegears.tiamat.rememberNavController
import com.example.character.presentation.CharactersScreen
import com.example.location.presentation.location.LocationScreen


data class CharactersArgs(val residentUrls: List<String>)

val LocationList: NavDestination<Unit> by navDestination {
    val nc = navController()
    LocationScreen(
        onLocationClick = { location ->
            nc.navigate(Characters, CharactersArgs(location.residents))
        }
    )
}

val Characters: NavDestination<CharactersArgs> by navDestination {
    val args = navArgs()
    val nc = navController()

    CharactersScreen(
        residentUrls = args.residentUrls,
        onBackClick = { nc.back() }
    )
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController(
        startDestination = LocationList,
        destinations = arrayOf(
            LocationList,
            Characters
        )
    )
    Navigation(navController)
}