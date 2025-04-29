package com.example.mvpteststrm.ui.forbrug

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mvpteststrm.R
import com.example.mvpteststrm.ui.components.BottomNavigationBar
@Composable
fun ForbrugPage(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Dit forbrug",
            style = MaterialTheme.typography.headlineMedium.copy(fontSize = 28.sp),
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        RealtimeConsumptionSection()
        Spacer(modifier = Modifier.height(16.dp))
        HistoricalConsumptionSection()
        Spacer(modifier = Modifier.height(24.dp))
        MinScoreSection()
    }
}
@Composable
fun RealtimeConsumptionSection() {
    Text(
        text = "Live elforbrug",
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(bottom = 5.dp)
    )

    InfoBullet("Se dit forbrug i realtid", "Tænd og sluk for elapparater se det påvirke dit forbrug")
    InfoBullet("Spring ventetiden over", "Slip for at vente 2–4 dage på at få dit forbrug")
    InfoBullet("Få indsigt i dine vaner", "Se hvordan dine forbrugsvaner ændrer sig i realtid")
}
@Composable
fun HistoricalConsumptionSection() {
    Text(
        text = "Historisk forbrug",
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(bottom = 5.dp)
    )

    InfoBullet("Se dit elforbrug", "Få overblik over dit historiske elforbrug")
    InfoBullet("Præcise elpriser", "Afgifterne for dit hus bliver automatisk ført ind i elpriserne.")
    InfoBullet("Beregn udgifter", "Få et overslag på dine eludgifter før du får din elregning.")
}
@Composable

fun MinScoreSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFEFFAF1), shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "💡 Din Strøm Score",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Se dine besparelser som aldrig før, og tag hånd på dit el-forbrug",
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .clip(RoundedCornerShape(8.dp)), // optional visual clip
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2196F3), // purple like your screenshot
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 4.dp
            )
        ) {
            Text("Se hvordan du klarer det")
        }
    }
}

@Composable
fun InfoBullet(title: String, description: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_profile), // Replace with actual icons later
            contentDescription = null,
            modifier = Modifier.size(18.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
            Text(
                text = description,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}
