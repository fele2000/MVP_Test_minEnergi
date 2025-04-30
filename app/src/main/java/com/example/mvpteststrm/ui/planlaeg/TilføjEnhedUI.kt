package com.example.mvpteststrm.ui.planlaeg

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvpteststrm.R
import com.example.mvpteststrm.data.model.planlaeg.Device
@Composable
fun TilføjEnhedUI(
    selectedDate: String,
    onDeviceSelected: (Device) -> Unit
) {
    var currentScreen by remember { mutableStateOf("main") }
    var selectedIconRes by remember { mutableStateOf<Int?>(null) }
    var selectedDeviceName by remember { mutableStateOf<String?>(null) }

    when (currentScreen) {
        "main" -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Vælg Enhed", fontSize = 22.sp, color = Color.Black, modifier = Modifier.padding(bottom = 16.dp))

                val deviceOptions = listOf(
                    "Vaskemaskine" to R.drawable.baseline_local_laundry_service_24,
                    "Elbil" to R.drawable.placeholder_ad_image,
                    "Mikroovn" to R.drawable.baseline_microwave_24,
                    "Ovn" to R.drawable.outline_oven_24,
                    "Opvaskemaskine" to R.drawable.outline_dishwasher_24,
                    "Andet" to R.drawable.baseline_question_mark_24
                )

                deviceOptions.chunked(2).forEach { row ->
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        row.forEach { (name, iconRes) ->
                            DeviceIcon(iconRes) {
                                selectedIconRes = iconRes
                                selectedDeviceName = name
                                currentScreen = "settings"
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }

        "settings" -> {
            if (selectedIconRes != null && selectedDeviceName != null) {
                TilføjEnhedIndstillinger(
                    iconRes = selectedIconRes!!,
                    deviceName = selectedDeviceName!!,
                    selectedDate = selectedDate,
                    onDeviceCreated = { device ->
                        onDeviceSelected(device)
                        currentScreen = "main"
                    },
                    onClose = { currentScreen = "main" }
                )
            }
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
