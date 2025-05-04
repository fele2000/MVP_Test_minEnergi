package com.example.mvpteststrm.ui.profil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Icon

import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mvpteststrm.R
import com.example.mvpteststrm.ui.components.BottomNavigationBar
@Composable
fun ProfilPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Min Profil",
            style = MaterialTheme.typography.headlineMedium.copy(fontSize = 28.sp),
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Main section
        ProfileOption("Vælg region", "Priser vises i DKK")
        ProfileOption("Prisindstillinger", "Ændrer indstillinger for priser")
        ProfileOption("Notifikationer", "Få besked når prisen er høj eller lav")

        Spacer(modifier = Modifier.height(24.dp))

        // Grey section with rounded background
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF0F0F0), shape = RoundedCornerShape(12.dp))
                .padding(8.dp)
        ) {
            ProfileOption("Dine fordele", "Kun for betalende kunder")
            ProfileOption("“I Stedet” Blog", "Få nyheder om elmarkedet")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .width(375.dp)
                .height(140.dp)

                .shadow(elevation = 6.dp, shape = RoundedCornerShape(12.dp))
                .background(Color(0xFFFFDD75), shape = RoundedCornerShape(6.dp)) // fallback background

                .clickable {
                    navController.navigate("score")
                }
                .align(Alignment.CenterHorizontally)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp), // Padding inside the box
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.speedometer),
                    contentDescription = "CO2 Dial",
                    contentScale = ContentScale.Fit, // Important: don't crop, fit nicely
                    modifier = Modifier
                        .weight(2.5f)
                        .fillMaxWidth()
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(375.dp)
                        .height(45.dp)
                        .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp)) // <-- Add shadow here
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


    }
}
@Composable
fun ProfileOption(title: String, subtitle: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .clickable {  }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_hexagon_24), // defualt ikoner
            contentDescription = null,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
            Text(text = subtitle, fontSize = 12.sp, color = Color.Gray)
        }

        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Gå til",
            modifier = Modifier.size(24.dp)
        )

    }
}
