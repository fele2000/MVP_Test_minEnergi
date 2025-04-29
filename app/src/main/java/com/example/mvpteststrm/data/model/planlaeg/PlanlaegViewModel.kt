package com.example.mvpteststrm.data.model.planlaeg

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class PlanlaegViewModel: ViewModel() {

    private val _devices = mutableStateListOf<Device>()
    val devices: List<Device> = _devices


    fun addDevice(device: Device) {
        _devices.add(device)
    }
}