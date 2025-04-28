package com.example.mvpteststrm.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvpteststrm.ui.findselskaber.FindSelskaberPage
import com.example.mvpteststrm.ui.forbrug.ForbrugPage
import com.example.mvpteststrm.ui.landing.LandingPage
import com.example.mvpteststrm.ui.planlaeg.PlanlaegPage
import com.example.mvpteststrm.ui.profil.ProfilPage

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "landing"
    ) {
        composable("landing") { LandingPage(navController) }
        composable("forbrug") { ForbrugPage(navController) }
        composable("findselskaber") { FindSelskaberPage(navController) }
        composable("planlæg") { PlanlaegPage(navController) }
        composable("profil") { ProfilPage(navController) }
    }
}
