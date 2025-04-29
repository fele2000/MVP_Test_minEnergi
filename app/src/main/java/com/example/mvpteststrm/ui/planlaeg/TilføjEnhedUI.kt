package com.example.mvpteststrm.ui.planlaeg

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvpteststrm.R
import com.example.mvpteststrm.data.model.planlaeg.Device
import com.example.mvpteststrm.data.model.planlaeg.PlanlaegViewModel

@Composable
fun TilføjEnhedUI(onDeviceSelected: (Device) -> Unit) {
    val viewModel: PlanlaegViewModel = viewModel()


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp), // top spacing
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Vælg Enhed",
            fontSize = 20.sp,
            color = Color.Black
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Spacer(modifier = Modifier.height(32.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Button(
                onClick = {
                    onDeviceSelected(Device(name = "Vaskemaskine", timeRange = "14-17", icon = R.drawable.baseline_local_laundry_service_24))
                }
            ) {
                Text("Vaskemaskine")
            }
            Button(
                onClick = {}
            ) {
                Text("ddd")
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Button(
                onClick = {}
            ) {
                Text("ddd")
            }
            Button(
                onClick = {}
            ) {
                Text("ddd")
            }
        }
    }
}


