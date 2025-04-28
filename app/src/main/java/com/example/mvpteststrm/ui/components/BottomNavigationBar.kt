package com.example.mvpteststrm.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.mvpteststrm.R

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_home), contentDescription = "Priser") },
            label = { Text("Priser") },
            selected = false,
            onClick = { navController.navigate("landing") }
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_usage), contentDescription = "Forbrug") },
            label = { Text("Forbrug") },
            selected = false,
            onClick = { navController.navigate("forbrug") }
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Find Selskaber") },
            label = { Text("El aftaler") },
            selected = false,
            onClick = { navController.navigate("findSelskaber") }
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_plan), contentDescription = "Planlæg") },
            label = { Text("Planlæg") },
            selected = false,
            onClick = { navController.navigate("planlæg") }
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_profile), contentDescription = "Profil") },
            label = { Text("Profil") },
            selected = false,
            onClick = { navController.navigate("profil") }
        )
    }
}


