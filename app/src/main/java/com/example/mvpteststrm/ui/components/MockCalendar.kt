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
import com.example.mvpteststrm.data.model.planlaeg.Device
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun MockCalendar(
    selectedDate: String?,
    onDateSelected: (String) -> Unit,
    devices: List<Device>
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

    val firstDayOfWeek = (calendar.get(Calendar.DAY_OF_WEEK) + 5) % 7
    val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

    val prevMonthCalendar = Calendar.getInstance().apply {
        set(currentYear, currentMonth, 1)
        add(Calendar.MONTH, -1)
    }
    val daysInPrevMonth = prevMonthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)

    val allDates = mutableListOf<Pair<String?, Boolean>>()

    for (i in firstDayOfWeek downTo 1) {
        val day = daysInPrevMonth - i + 1
        val date = Calendar.getInstance().apply {
            set(currentYear, currentMonth, 1)
            add(Calendar.MONTH, -1)
            set(Calendar.DAY_OF_MONTH, day)
        }
        val dateStr = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date.time)
        allDates.add(Pair(dateStr, false))
    }

    for (day in 1..daysInMonth) {
        val date = Calendar.getInstance().apply {
            set(currentYear, currentMonth, day)
        }
        val dateStr = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date.time)
        allDates.add(Pair(dateStr, true))
    }

    val nextDaysToShow = (7 - allDates.size % 7) % 7
    for (i in 1..nextDaysToShow) {
        val date = Calendar.getInstance().apply {
            set(currentYear, currentMonth, 1)
            add(Calendar.MONTH, 1)
            set(Calendar.DAY_OF_MONTH, i)
        }
        val dateStr = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date.time)
        allDates.add(Pair(dateStr, false))
    }

    val weeks = allDates.chunked(7)
    val daysOfWeek = listOf("M", "T", "O", "T", "F", "L", "S")
    val monthName = SimpleDateFormat("MMMM", Locale("da", "DK")).format(calendar.time).replaceFirstChar { it.uppercase() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(horizontal = 4.dp)
    ) {
        Text(text = currentYear.toString(), fontSize = 14.sp, color = Color.LightGray, modifier = Modifier.align(Alignment.CenterHorizontally))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("<", fontSize = 24.sp, color = Color.White, modifier = Modifier.clickable {
                if (currentMonth == 0) {
                    currentMonth = 11
                    currentYear -= 1
                } else currentMonth -= 1
            }.padding(horizontal = 16.dp))
            Text(text = monthName, fontSize = 28.sp, color = Color.White)
            Text(">", fontSize = 24.sp, color = Color.White, modifier = Modifier.clickable {
                if (currentMonth == 11) {
                    currentMonth = 0
                    currentYear += 1
                } else currentMonth += 1
            }.padding(horizontal = 16.dp))
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            daysOfWeek.forEach {
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    Text(text = it, color = Color.LightGray, fontSize = 12.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Column(modifier = Modifier.weight(1f)) {
            weeks.forEach { week ->
                Row(modifier = Modifier.fillMaxWidth().weight(1f)) {
                    week.forEach { (dateStr, isCurrentMonth) ->
                        val isToday = dateStr == today
                        val isSelected = dateStr == selectedDate

                        val cal = Calendar.getInstance().apply {
                            time = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(dateStr)!!
                        }
                        val day = cal.get(Calendar.DAY_OF_MONTH)
                        val dateDevices = devices.filter { it.date == dateStr }

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
                            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
                                Spacer(modifier = Modifier.height(6.dp))
                                if (dateStr != null) {
                                    when {
                                        isSelected -> Box(
                                            modifier = Modifier
                                                .size(28.dp)
                                                .background(Color(0xFF81C784), CircleShape),
                                            contentAlignment = Alignment.Center
                                        ) { Text(text = "$day", color = Color.Black, fontSize = 14.sp) }

                                        isToday -> Box(
                                            modifier = Modifier
                                                .size(28.dp)
                                                .background(Color(0xFF64B5F6), CircleShape),
                                            contentAlignment = Alignment.Center
                                        ) { Text(text = "$day", color = Color.Black, fontSize = 14.sp) }

                                        else -> Text(
                                            text = "$day",
                                            color = if (isCurrentMonth) Color.White else Color.Gray,
                                            fontSize = 14.sp
                                        )
                                    }
                                }

                                // Små farvede prikker for devices
                                dateDevices.forEach {
                                    Box(
                                        modifier = Modifier
                                            .padding(top = 4.dp)
                                            .width(24.dp)
                                            .height(6.dp)
                                            .background(Color(it.color), RoundedCornerShape(3.dp))
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
