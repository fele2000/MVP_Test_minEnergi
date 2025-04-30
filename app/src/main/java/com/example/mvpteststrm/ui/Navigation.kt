package com.example.mvpteststrm.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mvpteststrm.ui.findselskaber.FindSelskaberPage
import com.example.mvpteststrm.ui.forbrug.ForbrugPage
import com.example.mvpteststrm.ui.landing.LandingPage
import com.example.mvpteststrm.ui.planlaeg.PlanlaegPage
import com.example.mvpteststrm.ui.planlaeg.TilføjEnhedIndstillinger
import com.example.mvpteststrm.ui.profil.ProfilPage
import com.example.mvpteststrm.ui.score.ScorePage

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = "landing",
        modifier = Modifier.padding(innerPadding)
    ){
        composable("landing") { LandingPage(navController) }
        composable("forbrug") { ForbrugPage(navController) }
        composable("findSelskaber") { FindSelskaberPage(navController) }
        composable("planlaeg") { PlanlaegPage(navController) }
        composable("profil") { ProfilPage(navController) }
        composable("score") { ScorePage(navController) }

        composable("tilføjEnhedIndstillinger/{selectedDate}/{iconRes}/{name}") { backStackEntry ->
            val selectedDate = backStackEntry.arguments?.getString("selectedDate") ?: ""
            val iconRes = backStackEntry.arguments?.getString("iconRes")?.toIntOrNull() ?: 0
            val name = backStackEntry.arguments?.getString("name") ?: ""

            TilføjEnhedIndstillinger(
                icon = iconRes,
                name = name,
                selectedDate = selectedDate,
                onSave = {
                    // Når enhed gemmes, naviger tilbage til Planlæg-siden
                    navController.popBackStack("planlaeg", inclusive = false)
                }
            )
        }
    }
}
