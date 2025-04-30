package com.example.mvpteststrm.ui.planlaeg

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvpteststrm.R

@Composable
fun TilføjEnhedUI(
    selectedDate: String,
    onNavigateToSettings: (date: String, iconRes: Int, name: String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Vælg Enhed",
            fontSize = 22.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Første række
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            DeviceIcon(
                iconRes = R.drawable.baseline_local_laundry_service_24,
                onClick = {
                    onNavigateToSettings(selectedDate, R.drawable.baseline_local_laundry_service_24, "Vaskemaskine")
                }
            )
            DeviceIcon(
                iconRes = R.drawable.placeholder_ad_image,
                onClick = {
                    onNavigateToSettings(selectedDate, R.drawable.placeholder_ad_image, "Elbil")
                }
            )
        }

        // Anden række
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            DeviceIcon(
                iconRes = R.drawable.baseline_microwave_24,
                onClick = {
                    onNavigateToSettings(selectedDate, R.drawable.baseline_microwave_24, "Mikrobølgeovn")
                }
            )
            DeviceIcon(
                iconRes = R.drawable.outline_oven_24,
                onClick = {
                    onNavigateToSettings(selectedDate, R.drawable.outline_oven_24, "Ovn")
                }
            )
        }

        // Tredje række
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            DeviceIcon(
                iconRes = R.drawable.outline_dishwasher_24,
                onClick = {
                    onNavigateToSettings(selectedDate, R.drawable.outline_dishwasher_24, "Opvaskemaskine")
                }
            )
            DeviceIcon(
                iconRes = R.drawable.baseline_question_mark_24,
                onClick = {
                    onNavigateToSettings(selectedDate, R.drawable.baseline_question_mark_24, "Andet")
                }
            )
        }
    }
}

@Composable
fun DeviceIcon(
    iconRes: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .size(115.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF448AFF))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(72.dp)
        )
    }
}
