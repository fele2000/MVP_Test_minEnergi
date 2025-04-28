package com.example.mvpteststrm.ui.planlaeg

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mvpteststrm.ui.components.BottomNavigationBar

@Composable
fun PlanlaegPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Planlæg Page - coming soon!")

        Spacer(modifier = Modifier.weight(1f))

        BottomNavigationBar(navController)
    }
}
