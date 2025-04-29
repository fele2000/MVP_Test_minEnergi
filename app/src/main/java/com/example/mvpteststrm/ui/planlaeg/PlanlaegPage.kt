package com.example.mvpteststrm.ui.planlaeg

import MockCalendar
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mvpteststrm.ui.components.BottomNavigationBar
import com.example.mvpteststrm.ui.price.PriceGraph

@Composable
fun PlanlaegPage(navController: NavController) {
    var selectedTab by remember { mutableStateOf("I dag") }
    var selectedDate by remember { mutableStateOf<String?>(null) } // ingen valgt dato i starten

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Fast overskrift: Planlægning
        Text(
            text = "Planlægning",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = 28.sp
            ),
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tabs - viser den valgte dato som undertitel
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Dato-tab
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { selectedTab = "I dag" }
            ) {
                Text(
                    text = selectedDate ?: "I dag",
                    color = if (selectedTab == "I dag") Color.Black else Color.Gray,
                    fontSize = 18.sp
                )
                if (selectedTab == "I dag") {
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .width(30.dp)
                            .height(2.dp)
                            .background(Color.Black) // Sort streg under valgt
                    )
                }
            }

            // Kalender-tab
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { selectedTab = "Kalender" }
            ) {
                Text(
                    text = "Kalender",
                    color = if (selectedTab == "Kalender") Color.Black else Color.Gray,
                    fontSize = 18.sp
                )
                if (selectedTab == "Kalender") {
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .width(30.dp)
                            .height(2.dp)
                            .background(Color.Black) // Sort streg under valgt
                    )
                }
            }
        }


        Spacer(modifier = Modifier.height(16.dp))

        if (selectedTab == "I dag") {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                PriceGraph()
            }
            Spacer(modifier = Modifier.weight(1f))
        } else if (selectedTab == "Kalender") {
            Box(modifier = Modifier.weight(1f)) {
                MockCalendar(
                    selectedDate = selectedDate,
                    onDateSelected = { clickedDate ->
                        selectedDate = clickedDate
                        selectedTab = "I dag"
                    }
                )
            }
        }

    }
}


