package com.example.mvpteststrm.ui.planlaeg

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvpteststrm.data.model.planlaeg.Device

@Composable
fun TilføjEnhedIndstillinger(
    iconRes: Int,
    selectedDate: String,
    onDeviceCreated: (Device) -> Unit,
    onClose: () -> Unit
) {
    var selectedColor by remember { mutableStateOf(Color(0xFF4CAF50)) } // standard: grøn
    var selectedTimeRange by remember { mutableStateOf("14-17") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Indstil Enhed", fontSize = 22.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(16.dp))

        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(72.dp),
            tint = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Tidsrum:", fontSize = 18.sp)
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            listOf("08-11", "14-17", "18-21").forEach { range ->
                Text(
                    text = range,
                    fontSize = 16.sp,
                    color = if (selectedTimeRange == range) Color.Black else Color.Gray,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { selectedTimeRange = range }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Vælg farve:", fontSize = 18.sp)
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            listOf(Color.Red, Color.Green, Color.Blue, Color.Magenta).forEach { color ->
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(36.dp)
                        .background(color = color, shape = CircleShape)
                        .border(
                            width = if (selectedColor == color) 3.dp else 1.dp,
                            color = if (selectedColor == color) Color.Black else Color.Gray,
                            shape = CircleShape
                        )
                        .clickable { selectedColor = color }
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                onDeviceCreated(
                    Device(
                        name = "Vaskemaskine",
                        timeRange = selectedTimeRange,
                        icon = iconRes,
                        color = selectedColor.toArgb().toLong(),
                        date = selectedDate
                    )
                )
                onClose()
            },
            colors = ButtonDefaults.buttonColors(containerColor = selectedColor),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Tilføj", color = Color.White)
        }
    }
}
