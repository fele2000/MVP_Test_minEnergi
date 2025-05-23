package com.example.mvpteststrm.ui.planlaeg

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mvpteststrm.data.model.planlaeg.Device
import com.example.mvpteststrm.data.model.planlaeg.PlanlaegViewModel
import com.example.mvpteststrm.ui.components.BottomNavigationBar
import com.example.mvpteststrm.ui.components.MockCalendar
import com.example.mvpteststrm.ui.components.price.PriceGraph
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PlanlaegPage(navController: NavController) {
    var selectedTab by remember { mutableStateOf("I dag") }

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    var selectedDate by remember { mutableStateOf(LocalDate.now().format(formatter)) }

    var showSheet by remember { mutableStateOf(false) }

    val viewModel: PlanlaegViewModel = viewModel()
    val deviceList = viewModel.devices.collectAsState().value

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Planlægning",
            style = MaterialTheme.typography.headlineMedium.copy(fontSize = 28.sp),
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { selectedTab = "I dag" }
            ) {
                Text(
                    text = selectedDate,
                    color = if (selectedTab == "I dag") Color.Black else Color.Gray,
                    fontSize = 18.sp
                )
                if (selectedTab == "I dag") {
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .width(30.dp)
                            .height(2.dp)
                            .background(Color.Black)
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { selectedTab = "Kalender" }
            ) {
                Text(
                    text = "Kalender",
                    color = if (selectedTab == "Kalender") Color.Black else Color.Gray,
                    fontSize = 18.sp
                )
                if (selectedTab == "Kalender") {
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .width(30.dp)
                            .height(2.dp)
                            .background(Color.Black)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (selectedTab == "I dag") {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    PriceGraph()
                }

                items(deviceList.filter { it.date == selectedDate }) { device ->
                    DeviceCard(device)
                }

                item {
                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { showSheet = true }) {
                        Text("Tilføj Enhed")
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            if (showSheet) {
                Dialog(onDismissRequest = { showSheet = false }) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        shape = RoundedCornerShape(30.dp),
                        color = Color.LightGray
                    ) {
                        TilføjEnhedUI(
                            selectedDate = selectedDate,
                            onDeviceSelected = { device ->
                                viewModel.addDevice(device)
                                showSheet = false
                            }
                        )
                    }
                }
            }
        } else if (selectedTab == "Kalender") {
            Box(modifier = Modifier.weight(1f)) {
                MockCalendar(
                    selectedDate = selectedDate,
                    onDateSelected = { clickedDate ->
                        selectedDate = clickedDate
                        selectedTab = "I dag"
                    },
                    devices = deviceList
                )
            }
        }
    }
}

@Composable
fun DeviceCard(device: Device) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(color = Color.LightGray)
            .height(42.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = device.icon),
            contentDescription = device.name,
            modifier = Modifier.size(26.dp),
            tint = Color.Black
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = device.name, fontSize = 18.sp)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Tidsrum: ${device.timeRange}", fontSize = 18.sp)
    }
}
