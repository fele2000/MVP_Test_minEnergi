package com.example.mvpteststrm.ui.score
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvpteststrm.R@Composable
fun ScorePage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                text = "Mine tal",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Sammenlign dit strømforbrug med lignende husstande",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFD9D9D9), RoundedCornerShape(16.dp))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.dialer1),
                contentDescription = "Strøm dial",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(150.dp)
            )
            Button(
                onClick = {  },
                modifier = Modifier
            ) {
                Text("Skift visning")
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(horizontal = 14.dp, vertical = 8.dp)

                .width(375.dp)
                .height(45.dp)
                .shadow(elevation = 6.dp, shape = RoundedCornerShape(8.dp))
                .background(Color(0xFF22FF1B), shape = RoundedCornerShape(4.dp))
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Du bruger 25% mindre strøm og sparer 85 kr mere end Gennemsnitlig husstand",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF2E7D32)
            )
        }


        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = "Vælg din husstandstype",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("Single", "Par", "Familie", "Tilpas").forEachIndexed { index, label ->
                    Box(
                        modifier = Modifier
                            .background(
                                if (index == 2) Color(0xFFD0E8FF) else Color(0xFFE0E0E0),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 14.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = label,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }


        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(
                text = "Sammenligning",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ComparisonBox(
                    title = "Din husstand",
                    kWh = "67 kWh",
                    kr = "245 kr",

                    bgColor = Color(0xFFE5F9EC)
                )
                ComparisonBox(
                    title = "Gennemsnitlig husstand",
                    kWh = "89 kWh",
                    kr = "330 kr",

                    bgColor = Color(0xFFFDEDED)
                )
            }

        }
    }
}



@Composable
fun ComparisonBox(
    title: String,
    kWh: String,
    kr: String,
    bgColor: Color
) {
    Surface(
        modifier = Modifier
            .width(160.dp)
            .height(160.dp),
        shape = RoundedCornerShape(12.dp),
        color = bgColor,
        tonalElevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium
                )

            }

            Divider(
                color = Color.Gray.copy(alpha = 0.2f),
                modifier = Modifier.padding(vertical = 6.dp)
            )


            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text("Strømforbrug", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                    Text(kWh, style = MaterialTheme.typography.bodySmall)
                }

                Column(modifier = Modifier.fillMaxWidth()) {
                    Text("Elregning", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                    Text(kr, style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}
