package com.example.mvpteststrm.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvpteststrm.ui.landing.LandingPage

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "landing"
    ) {
        composable("landing") { LandingPage(navController) }
        // Later you can add more:
        // composable("forbrug") { ForbrugPage(navController) }
        // composable("findSelskaber") { FindSelskabPage(navController) }
        // etc.
    }
}
