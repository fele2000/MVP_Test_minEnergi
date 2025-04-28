package com.example.mvpteststrm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvpteststrm.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // This is your landing page UI
                LandingPage()
            }
        }
    }
}

@Composable
fun LandingPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Title
        Text(
            text = "Elpriser",
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 28.sp,
            color = Color.Black
        )

        // Date Text
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "I dag - Fredag 11. April",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        // Bar Chart Placeholder Image
        Spacer(modifier = Modifier.height(24.dp))
        Image(
            painter = painterResource(id = R.drawable.placeholder_bar_chart),
            contentDescription = "Bar Chart Placeholder",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        // CO2-friendly Electricity Section
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Green)
        ) {
            Text(
                text = "CO2-venlig strøm: 52%",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(12.dp)
            )
        }

        // Placeholder Advertisement (Image)
        Spacer(modifier = Modifier.height(16.dp))
       Image(
            painter = painterResource(id = R.drawable.placeholder_ad_image),
            contentDescription = "Ad Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )

        // Bottom Navigation Bar
        Spacer(modifier = Modifier.weight(1f))  // Spacer to push content up
         BottomNavigationBar()
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Priser
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_home), contentDescription = "Home") },
            label = { Text("priser") },
            selected = false,
            onClick = { /* Handle click */ }
        )
        // Forbrug
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_usage), contentDescription = "Profile") },
            label = { Text("Forbrug") },
            selected = false,
            onClick = { /* Handle click */ }
        )
        // Find Selskab
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Search") },
            label = { Text("Find Selskaber") },
            selected = false,
            onClick = { /* Handle click */ }
        )
        // Planlæg
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_plan), contentDescription = "Profile") },
            label = { Text("Planlæg") },
            selected = false,
            onClick = { /* Handle click */ }
        )
        // Profile
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_profile), contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = false,
            onClick = { /* Handle click */ }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        LandingPage()
    }
}
