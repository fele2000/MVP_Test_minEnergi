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
        Image(
            painter = painterResource(id = R.drawable.speedometer),
            contentDescription = "CO2 Dial",
            contentScale = ContentScale.Fit, // Important: don't crop, fit nicely
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        )

    }
}
@Composable
fun ProfileOption(title: String, subtitle: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .clickable { /* TODO: navController.navigate(...) */ }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_profile), // Replace with actual icons later
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
