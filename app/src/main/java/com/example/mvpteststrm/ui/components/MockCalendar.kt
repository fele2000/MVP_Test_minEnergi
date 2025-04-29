package com.example.mvpteststrm.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun MockCalendar(
    selectedDate: String?,
    onDateSelected: (String) -> Unit
) {
    val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

    val todayCalendar = Calendar.getInstance()
    var currentYear by remember { mutableStateOf(todayCalendar.get(Calendar.YEAR)) }
    var currentMonth by remember { mutableStateOf(todayCalendar.get(Calendar.MONTH)) }


    val firstOfMonth = Calendar.getInstance().apply {
        set(currentYear, currentMonth, 1)
    }

    val rawDay = firstOfMonth.get(Calendar.DAY_OF_WEEK)
    val startOffset = (rawDay + 5) % 7

    val daysInMonth = firstOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH)
    val allDates = mutableListOf<String?>()

    repeat(startOffset) { allDates.add(null) }

    for (day in 1..daysInMonth) {
        val date = Calendar.getInstance().apply {
            set(currentYear, currentMonth, day)
        }
        val formatted = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date.time)
        allDates.add(formatted)
    }

    while (allDates.size % 7 != 0) {
        allDates.add(null)
    }

    val weeks = allDates.chunked(7)
    val daysOfWeek = listOf("M", "T", "O", "T", "F", "L", "S")

    val monthName = SimpleDateFormat("MMMM", Locale.getDefault()).format(
        Calendar.getInstance().apply { set(Calendar.MONTH, currentMonth) }.time
    ).uppercase()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(horizontal = 4.dp)
    ) {
        // ÅR øverst småt
        Text(
            text = currentYear.toString(),
            fontSize = 14.sp,
            color = Color.LightGray,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp)
        )

        // Måned + pile
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "<",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    .clickable {
                        // Skift til forrige måned
                        if (currentMonth == 0) {
                            currentMonth = 11
                            currentYear -= 1
                        } else {
                            currentMonth -= 1
                        }
                    }
                    .padding(horizontal = 16.dp)
            )

            Text(
                text = monthName,
                fontSize = 28.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )

            Text(
                text = ">",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    .clickable {
                        // Skift til næste måned
                        if (currentMonth == 11) {
                            currentMonth = 0
                            currentYear += 1
                        } else {
                            currentMonth += 1
                        }
                    }
                    .padding(horizontal = 16.dp)
            )
        }

        // Ugedage
        Row(modifier = Modifier.fillMaxWidth()) {
            daysOfWeek.forEach {
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    Text(text = it, color = Color.LightGray, fontSize = 12.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Dato-felterne
        Column(modifier = Modifier.weight(1f)) {
            weeks.forEach { week ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    week.forEach { fullDate ->
                        val isToday = fullDate == today
                        val isSelected = fullDate == selectedDate

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .padding(2.dp)
                                .background(Color(0xFF1E1E1E), RoundedCornerShape(4.dp))
                                .clickable(enabled = fullDate != null) {
                                    fullDate?.let { onDateSelected(it) }
                                },
                            contentAlignment = Alignment.TopCenter
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Spacer(modifier = Modifier.height(6.dp))

                                if (fullDate != null) {
                                    val cal = Calendar.getInstance()
                                    cal.time = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(fullDate)!!
                                    val dag = cal.get(Calendar.DAY_OF_MONTH)

                                    when {
                                        isSelected -> {
                                            Box(
                                                modifier = Modifier
                                                    .size(28.dp)
                                                    .background(Color(0xFF81C784), CircleShape),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(text = "$dag", fontSize = 14.sp, color = Color.Black)
                                            }
                                        }
                                        isToday -> {
                                            Box(
                                                modifier = Modifier
                                                    .size(28.dp)
                                                    .background(Color(0xFF64B5F6), CircleShape),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(text = "$dag", fontSize = 14.sp, color = Color.Black)
                                            }
                                        }
                                        else -> {
                                            Text(text = "$dag", fontSize = 14.sp, color = Color.White)
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
}
