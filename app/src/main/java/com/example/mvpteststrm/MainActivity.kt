package com.example.mvpteststrm

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.mvpteststrm.ui.Navigation
import com.example.mvpteststrm.ui.components.BottomNavigationBar

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MaterialTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController = navController, selectedItem = "")
                    }
                ) { innerPadding ->
                    Navigation(navController = navController, innerPadding = innerPadding)
                }
            }
        }
    }
}
