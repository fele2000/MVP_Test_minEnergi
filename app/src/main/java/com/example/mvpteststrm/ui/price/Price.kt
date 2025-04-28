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
        Graph(prices = prices)

        Spacer(modifier = Modifier.height(8.dp))

        // Tidspunkterne nederst
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            prices.forEach { price ->
                Text(
                    text = price.time.toString().padStart(2, '0'),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.width(12.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun Graph(prices: List<Price>) {
    val maxPrice = prices.maxOfOrNull { it.pricePerKwh } ?: 1.0

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(horizontal = 14.dp)
    ) {
        val barWidth = size.width / prices.size
        prices.forEachIndexed { index, price ->
            val barHeight = (price.pricePerKwh / maxPrice) * size.height
            val barLeft = index * barWidth

            val barColor = when {
                price.isNow -> Color.Gray
                price.pricePerKwh > 2.0 -> Color(0xFFFFC107)
                else -> Color(0xFF4CAF50)
            }

            drawRect(
                color = barColor,
                topLeft = Offset(barLeft, (size.height - barHeight).toFloat()),
                size = Size(barWidth * 0.8f, barHeight.toFloat())
            )
        }
    }
}
