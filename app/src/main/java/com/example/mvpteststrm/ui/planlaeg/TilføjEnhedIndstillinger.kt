package com.example.mvpteststrm.ui.planlaeg

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvpteststrm.data.model.planlaeg.Device
import com.example.mvpteststrm.data.model.price.PriceViewModel

@Composable
fun TilføjEnhedIndstillinger(
    icon: Int,
    name: String,
    selectedDate: String,
    onSave: (Device) -> Unit
) {
    val priceViewModel: PriceViewModel = viewModel()
    val prices by priceViewModel.prices.collectAsState()

    var duration by remember { mutableStateOf("1") }
    var fromHour by remember { mutableStateOf("17") }
    var toHour by remember { mutableStateOf("23") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Indstillinger for $name",
            fontSize = 22.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(80.dp),
            tint = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Varighed i timer", fontSize = 16.sp)
        TextField(
            value = duration,
            onValueChange = { duration = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text("Tilgængeligt tidsrum", fontSize = 16.sp)
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = fromHour,
                onValueChange = { fromHour = it },
                label = { Text("Fra (fx 17)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 4.dp)
            )
            TextField(
                value = toHour,
                onValueChange = { toHour = it },
                label = { Text("Til (fx 23)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val start = fromHour.toIntOrNull() ?: 17
                val end = toHour.toIntOrNull() ?: 23
                val durationHours = duration.toIntOrNull() ?: 1

                val cheapestStart = findCheapestStartTimeFromPrices(
                    prices = prices.map { it.time to it.pricePerKwh }.toMap(),
                    start = start,
                    end = end,
                    duration = durationHours
                )

                val timeRange = if (cheapestStart != null)
                    "$cheapestStart-${cheapestStart + durationHours}"
                else "$start-$end"

                onSave(
                    Device(
                        name = name,
                        timeRange = timeRange,
                        icon = icon,
                        color = 0xFF448AFF,
                        date = selectedDate
                    )
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Gem Enhed")
        }
    }
}

fun findCheapestStartTimeFromPrices(
    prices: Map<Int, Double>,
    start: Int,
    end: Int,
    duration: Int
): Int? {
    var cheapestHour: Int? = null
    var minAvg = Double.MAX_VALUE

    for (hour in start..(end - duration)) {
        val window = (hour until hour + duration)
        val avgPrice = window.map { prices[it] ?: Double.MAX_VALUE }.average()
        if (avgPrice < minAvg) {
            minAvg = avgPrice
            cheapestHour = hour
        }
    }

    return cheapestHour
}
