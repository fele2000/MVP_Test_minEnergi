import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

@Composable
fun MockCalendar(
    selectedDate: String?, // Får den valgte dato med
    onDateSelected: (String) -> Unit
) {
    val daysOfWeek = listOf("M", "T", "O", "T", "F", "L", "S")
    val weeks = listOf(
        listOf("31", "1", "2", "3", "4", "5", "6"),
        listOf("7", "8", "9", "10", "11", "12", "13"),
        listOf("14", "15", "16", "17", "18", "19", "20"),
        listOf("21", "22", "23", "24", "25", "26", "27"),
        listOf("28", "29", "30", "1", "2", "3", "4")
    )

    val calendar = Calendar.getInstance()
    val today = calendar.get(Calendar.DAY_OF_MONTH).toString()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(horizontal = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for (day in daysOfWeek) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(2.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = day,
                        fontSize = 12.sp,
                        color = Color.LightGray
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            for (week in weeks) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    for (date in week) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .padding(2.dp)
                                .background(
                                    color = Color(0xFF1E1E1E),
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .clickable {
                                    onDateSelected("$date. maj") // klik sætter dato
                                },
                            contentAlignment = Alignment.TopCenter
                        ) {
                            if (date.isNotBlank()) {
                                when {
                                    selectedDate == "$date. maj" -> {
                                        // Valgt dato: grøn cirkel 🟢
                                        Box(
                                            modifier = Modifier
                                                .padding(top = 6.dp)
                                                .size(30.dp)
                                                .background(
                                                    color = Color(0xFF81C784), // Grøn farve
                                                    shape = CircleShape
                                                ),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = date,
                                                fontSize = 14.sp,
                                                color = Color.Black
                                            )
                                        }
                                    }
                                    date == today -> {
                                        // Dags dato: blå cirkel 🔵
                                        Box(
                                            modifier = Modifier
                                                .padding(top = 6.dp)
                                                .size(30.dp)
                                                .background(
                                                    color = Color(0xFF64B5F6), // Blå farve
                                                    shape = CircleShape
                                                ),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = date,
                                                fontSize = 14.sp,
                                                color = Color.Black
                                            )
                                        }
                                    }
                                    else -> {
                                        // Almindelige datoer
                                        Text(
                                            text = date,
                                            fontSize = 14.sp,
                                            color = Color.White,
                                            modifier = Modifier.padding(top = 6.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


