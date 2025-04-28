package com.example.mvpteststrm.ui.price

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.nativeCanvas
import com.example.mvpteststrm.data.model.Price

// Noget af nedenstående er med hjælp fra chatten.

@Composable
fun PriceGraph(viewModel: PriceViewModel = viewModel()) {
    val prices by viewModel.prices.collectAsState()

    val cheapest = prices.minByOrNull { it.pricePerKwh }
    val mostExpensive = prices.maxByOrNull { it.pricePerKwh }
    val now = prices.find { it.isNow }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Tre overskrifter
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "${cheapest?.pricePerKwh} kr\nKl. ${cheapest?.time}-" + "${(cheapest?.time?.plus(1))?.rem(24)}",
                textAlign = TextAlign.Center
            )
            Text(
                text = "${now?.pricePerKwh} kr\nLige nu",
                textAlign = TextAlign.Center
            )
            Text(
                text = "${mostExpensive?.pricePerKwh} kr\nKl. ${mostExpensive?.time}-" + "${(mostExpensive?.time?.plus(1))?.rem(24)}",
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Grafen
        GraphWithTiltedPricesAndTimes(prices = prices)

        Spacer(modifier = Modifier.height(8.dp))

        // Tidspunkterne nederst

    }
}@Composable
fun GraphWithTiltedPricesAndTimes(prices: List<Price>) {
    val maxPrice = remember(prices) { prices.maxOfOrNull { it.pricePerKwh } ?: 1.0 }

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(380.dp) // Taller to fit price and time labels
            .padding(horizontal = 14.dp)
    ) {
        val barWidth = size.width / prices.size
        val priceLabelHeight = 50.dp.toPx()
        val timeLabelHeight = 30.dp.toPx()
        val availableHeight = size.height - priceLabelHeight - timeLabelHeight

        prices.forEachIndexed { index, price ->
            val barHeight = (price.pricePerKwh / maxPrice) * availableHeight
            val barLeft = index * barWidth

            val barColor = when {
                price.isNow -> Color.Gray
                price.pricePerKwh > 2.0 -> Color(0xFFFFC107)
                else -> Color(0xFF4CAF50)
            }

            // Draw tilted price label
            drawContext.canvas.nativeCanvas.apply {
                save() // Save the current state
                val textPaint = android.graphics.Paint().apply {
                    color = android.graphics.Color.BLACK
                    textAlign = android.graphics.Paint.Align.CENTER
                    textSize = 24f
                    isAntiAlias = true
                }
                val x = barLeft + (barWidth * 0.62f)
                val y = priceLabelHeight - 25f
                rotate(-70f, x, y) // Rotate around the text position (negative = tilt right)
                drawText(
                    String.format("%.1f", price.pricePerKwh),
                    x,
                    y,
                    textPaint
                )
                restore() // Restore to normal after rotation
            }

            // Draw the bar
            drawRect(
                color = barColor,
                topLeft = Offset(barLeft,
                    (priceLabelHeight + (availableHeight - barHeight)).toFloat()
                ),
                size = Size(barWidth * 0.8f, barHeight.toFloat())
            )

            // Draw time label under the bar
            drawContext.canvas.nativeCanvas.apply {
                val timePaint = android.graphics.Paint().apply {
                    color = android.graphics.Color.DKGRAY
                    textAlign = android.graphics.Paint.Align.CENTER
                    textSize = 22f
                    isAntiAlias = true

                }
                drawText(
                    price.time.toString(),
                    barLeft + (barWidth * 0.4f),
                    size.height - 35f,
                    timePaint
                )
            }
        }
    }
}
