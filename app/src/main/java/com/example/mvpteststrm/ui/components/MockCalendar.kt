package com.example.mvpteststrm.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

    val initialCalendar = Calendar.getInstance()
    var currentYear by remember { mutableStateOf(initialCalendar.get(Calendar.YEAR)) }
    var currentMonth by remember { mutableStateOf(initialCalendar.get(Calendar.MONTH)) }

    val calendar = Calendar.getInstance().apply {
        set(Calendar.YEAR, currentYear)
        set(Calendar.MONTH, currentMonth)
        set(Calendar.DAY_OF_MONTH, 1)
    }

    val firstDayOfWeek = (calendar.get(Calendar.DAY_OF_WEEK) + 5) % 7 // Mandag = 0
    val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

    val allDates = mutableListOf<String?>()
    repeat(firstDayOfWeek) { allDates.add(null) }
    for (day in 1..daysInMonth) {
        val date = Calendar.getInstance().apply {
            set(currentYear, currentMonth, day)
        }
        allDates.add(SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date.time))
    }
    while (allDates.size % 7 != 0) allDates.add(null)

    val weeks = allDates.chunked(7)
    val daysOfWeek = listOf("M", "T", "O", "T", "F", "L", "S")

    val monthName = SimpleDateFormat("MMMM", Locale("da", "DK")).format(calendar.time).replaceFirstChar { it.uppercase() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(horizontal = 4.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        // År
        Text(
            text = currentYear.toString(),
            fontSize = 14.sp,
            color = Color.LightGray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        // Måned + navigation
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
                color = Color.White
            )

            Text(
                text = ">",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    .clickable {
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

        // Kalender-rækker
        Column(modifier = Modifier.weight(1f)) {
            weeks.forEach { week ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    week.forEach { dateStr ->
                        val isToday = dateStr == today
                        val isSelected = dateStr == selectedDate

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .padding(2.dp)
                                .background(Color(0xFF1E1E1E), RoundedCornerShape(4.dp))
                                .clickable(enabled = dateStr != null) {
                                    dateStr?.let { onDateSelected(it) }
                                },
                            contentAlignment = Alignment.TopCenter
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Spacer(modifier = Modifier.height(6.dp))
                                if (dateStr != null) {
                                    val cal = Calendar.getInstance().apply {
                                        time = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(dateStr)!!
                                    }
                                    val day = cal.get(Calendar.DAY_OF_MONTH)

                                    when {
                                        isSelected -> {
                                            Box(
                                                modifier = Modifier
                                                    .size(28.dp)
                                                    .background(Color(0xFF81C784), CircleShape),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(text = "$day", color = Color.Black, fontSize = 14.sp)
                                            }
                                        }
                                        isToday -> {
                                            Box(
                                                modifier = Modifier
                                                    .size(28.dp)
                                                    .background(Color(0xFF64B5F6), CircleShape),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(text = "$day", color = Color.Black, fontSize = 14.sp)
                                            }
                                        }
                                        else -> {
                                            Text(text = "$day", color = Color.White, fontSize = 14.sp)
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
