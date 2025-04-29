package com.example.mvpteststrm.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mvpteststrm.ui.components.BottomNavigationBar
import com.example.mvpteststrm.ui.findselskaber.FindSelskaberPage
import com.example.mvpteststrm.ui.forbrug.ForbrugPage
import com.example.mvpteststrm.ui.landing.LandingPage
import com.example.mvpteststrm.ui.planlaeg.PlanlaegPage
import com.example.mvpteststrm.ui.profil.ProfilPage
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "landing"

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController, selectedItem = currentRoute)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "landing",
            modifier = Modifier.padding(innerPadding)

        ) {
            composable("landing") { LandingPage(navController) }
            composable("forbrug") { ForbrugPage(navController) }
            composable("findSelskaber") { FindSelskaberPage(navController) }
            composable("planlaeg") { PlanlaegPage(navController) }
            composable("profil") { ProfilPage(navController) }
        }
    }
}