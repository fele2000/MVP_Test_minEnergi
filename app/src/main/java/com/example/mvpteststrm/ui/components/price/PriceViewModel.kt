package com.example.mvpteststrm.ui.components.price

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.mvpteststrm.data.model.Price
import java.time.LocalTime

class PriceViewModel : ViewModel() {
    val prices: StateFlow<List<Price>> = MutableStateFlow(generateMockPrices())

    companion object {
        private fun generateMockPrices(): List<Price> {
            return listOf(
                Price(pricePerKwh = 1.5, time = 0),
                Price(pricePerKwh = 1.8, time = 1),
                Price(pricePerKwh = 2.0, time = 2),
                Price(pricePerKwh = 2.5, time = 3),
                Price(pricePerKwh = 3.0, time = 4),
                Price(pricePerKwh = 2.8, time = 5),
                Price(pricePerKwh = 2.6, time = 6),
                Price(pricePerKwh = 2.4, time = 7),
                Price(pricePerKwh = 2.2, time = 8),
                Price(pricePerKwh = 2.0, time = 9),
                Price(pricePerKwh = 1.7, time = 10),
                Price(pricePerKwh = 1.5, time = 11),
                Price(pricePerKwh = 1.4, time = 12),
                Price(pricePerKwh = 1.3, time = 13),
                Price(pricePerKwh = 1.5, time = 14),
                Price(pricePerKwh = 1.7, time = 15),
                Price(pricePerKwh = 1.9, time = 16),
                Price(pricePerKwh = 2.0, time = 17),
                Price(pricePerKwh = 1.8, time = 18),
                Price(pricePerKwh = 1.7, time = 19),
                Price(pricePerKwh = 1.6, time = 20),
                Price(pricePerKwh = 1.5, time = 21),
                Price(pricePerKwh = 1.4, time = 22),
                Price(pricePerKwh = 1.3, time = 23),
            )
        }
    }
}
