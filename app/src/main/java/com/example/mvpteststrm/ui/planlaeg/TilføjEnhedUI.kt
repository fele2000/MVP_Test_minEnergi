package com.example.mvpteststrm.ui.planlaeg

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.mvpteststrm.R
import com.example.mvpteststrm.data.model.planlaeg.Device

@Composable
fun TilføjEnhedUI(
    selectedDate: String?,
    onDeviceSelected: (Device) -> Unit
) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var timeRange by remember { mutableStateOf(TextFieldValue("")) }
    var selectedColor by remember { mutableStateOf(Color.Red) }

    val colorOptions = listOf(Color.Red, Color.Blue, Color.Green, Color.Yellow, Color.Cyan, Color.Magenta)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Text("Tilføj Enhed", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Navn på enhed") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = timeRange,
            onValueChange = { timeRange = it },
            label = { Text("Tidsrum (fx 08:00 - 10:00)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Vælg farve:")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            colorOptions.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(color, shape = RoundedCornerShape(50))
                        .border(
                            width = if (selectedColor == color) 3.dp else 1.dp,
                            color = if (selectedColor == color) Color.Black else Color.Gray,
                            shape = RoundedCornerShape(50)
                        )
                        .clickable { selectedColor = color }
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                if (selectedDate != null) {
                    val device = Device(
                        name = name.text,
                        icon = R.drawable.baseline_local_laundry_service_24, // Skift evt. til dit eget ikon
                        timeRange = timeRange.text,
                        color = selectedColor.toArgb().toLong(),
                        date = selectedDate
                    )
                    onDeviceSelected(device)
                }
            },
            enabled = name.text.isNotBlank() && timeRange.text.isNotBlank() && selectedDate != null
        ) {
            Text("Tilføj")
        }
    }
}
