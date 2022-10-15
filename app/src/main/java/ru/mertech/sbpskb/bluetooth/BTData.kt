package ru.mertech.sbpskb.bluetooth
 data class BTData(
     val messages: List<UARTOutputRecord> = emptyList(),
     val batteryLevel: Int? = null,
)
 data class UARTOutputRecord(
    val text: String,
    val timestamp: Long = System.currentTimeMillis()
)
