package com.example.mvpteststrm.ui.planlaeg

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvpteststrm.R
import com.example.mvpteststrm.data.model.planlaeg.Device
import com.example.mvpteststrm.data.model.planlaeg.PlanlaegViewModel
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun TilføjEnhedUI(onDeviceSelected: (Device) -> Unit) {
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
            DeviceIcon(R.drawable.baseline_local_laundry_service_24) {
                onDeviceSelected(Device("Vaskemaskine", "14-17", R.drawable.baseline_local_laundry_service_24))
            }
            DeviceIcon(R.drawable.placeholder_ad_image) { }
        }

        // Anden række
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
           DeviceIcon(R.drawable.baseline_microwave_24)  {}
            DeviceIcon(R.drawable.outline_oven_24) {}
        }

        // Tredje række
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
           DeviceIcon(R.drawable.outline_dishwasher_24) {  }
            DeviceIcon(R.drawable.baseline_question_mark_24) { }
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
            .padding(start = 8.dp,
                top = 16.dp,
                end = 8.dp,
                bottom = 12.dp)
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