package com.example.mvpteststrm.data.model.planlaeg

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PlanlaegViewModel : ViewModel() {
    private val _devices = MutableStateFlow<List<Device>>(emptyList())
    val devices: StateFlow<List<Device>> = _devices

    fun addDevice(device: Device) {
        _devices.value = _devices.value + device
    }
}
