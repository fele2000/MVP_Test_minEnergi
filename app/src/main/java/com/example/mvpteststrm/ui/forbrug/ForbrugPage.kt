package com.example.mvpteststrm.ui.forbrug

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
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
        MinScoreSection(navController)
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
fun MinScoreSection(navController: NavController) {
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.speedometer),
                contentDescription = "CO2 Dial",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .weight(2.5f)
                    .fillMaxWidth()
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(375.dp)
                    .height(45.dp)
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp))
                    .background(Color(0xFF2196F3), shape = RoundedCornerShape(8.dp))
                    .align(Alignment.CenterHorizontally)
            ) {

                Text(
                    text = "Klik her og udforsk din Strøm Score!",
                    color = Color(0xFFFFFFFF),
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier


                )
            }
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
            painter = painterResource(id = R.drawable.baseline_hexagon_24),
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
