package com.example.mvpteststrm.ui.landing

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
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
                fontSize = 32.sp
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
                fontSize = 16.sp
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

        Spacer(modifier = Modifier.height(14.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(375.dp)
                .height(45.dp)
                .shadow(elevation = 6.dp, shape = RoundedCornerShape(8.dp))
                .background(Color(0xFF22FF1B), shape = RoundedCornerShape(4.dp))
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "CO2-venlig strøm: 52%",
                color = Color.White,
                fontSize = 18.sp,
            )
        }

        Spacer(modifier = Modifier.height(9.dp))
        Box(
            modifier = Modifier
                .width(375.dp)
                .height(140.dp)

                .shadow(elevation = 6.dp, shape = RoundedCornerShape(12.dp))
                .background(Color(0xFFFFDD75), shape = RoundedCornerShape(6.dp))

                .clickable {
                    navController.navigate("score")
                }
                .align(Alignment.CenterHorizontally)
        )

        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.speedometer),
                    contentDescription = "CO2 Dial",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .weight(2.5f)
                        .fillMaxWidth()
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(375.dp)
                        .height(45.dp)
                        .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp))
                        .background(Color(0xFF2196F3), shape = RoundedCornerShape(8.dp))
                        .align(Alignment.CenterHorizontally)
                ) {

                    Text(
                        text = "Klik her og udforsk din Strøm Score!",
                        color = Color(0xFFFFFFFF),
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier


                    )
                }
            }
        }





        Spacer(modifier = Modifier.weight(1f))

    }
}

