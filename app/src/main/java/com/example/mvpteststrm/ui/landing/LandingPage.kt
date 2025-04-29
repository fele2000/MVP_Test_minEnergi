package com.example.mvpteststrm.ui.landing

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mvpteststrm.R
import com.example.mvpteststrm.ui.components.BottomNavigationBar
import com.example.mvpteststrm.ui.components.price.PriceGraph

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LandingPage(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Elpriser",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = 28.sp
            ),
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "I dag - Fredag 11. April",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 12.sp
            ),
        color = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

       Box() {
           PriceGraph()
       }

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(375.dp)
                .height(45.dp)
                .background(Color.Green)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "CO2-venlig strøm: 52%",
                color = Color.White,
                fontSize = 18.sp,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .width(375.dp)
                .height(140.dp)
                .background(Color.LightGray)
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "CO2-venlig strøm: 52%",
                    color = Color.White,
                    fontSize = 20.sp
                )

            }
        }




        Spacer(modifier = Modifier.weight(1f))

    }
}

