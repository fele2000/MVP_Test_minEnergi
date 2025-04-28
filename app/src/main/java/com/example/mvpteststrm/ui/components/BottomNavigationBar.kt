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
fun BottomNavigationBar(navController: NavController, selectedItem: String) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_home), contentDescription = "Priser") },
            label = { Text("Priser") },
            selected = selectedItem == "landing",
            onClick = { navController.navigate("landing") }
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_usage), contentDescription = "Forbrug") },
            label = { Text("Forbrug") },
            selected = selectedItem == "forbrug",
            onClick = { navController.navigate("forbrug") }
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Find Selskaber") },
            label = { Text("El aftaler") },
            selected = selectedItem == "findSelskaber",
            onClick = { navController.navigate("findSelskaber") }
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_plan), contentDescription = "Planlæg") },
            label = { Text("Planlæg") },
            selected = selectedItem == "planlaeg",
            onClick = { navController.navigate("planlaeg") }
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_profile), contentDescription = "Profil") },
            label = { Text("Profil") },
            selected = selectedItem == "profil",
            onClick = { navController.navigate("profil") }
        )
    }
}


