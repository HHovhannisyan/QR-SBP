package ru.mertech.sbpskb

import java.util.*

object Constants {
    const val GPS_REQUEST = 1001
    const val BLUETOOTH_REQ_CODE = 1
    const val LOCATION_PERMISSION_REQUEST_CODE = 2

    @JvmField
    var isGPS = false
    val btSuccess =
        byteArrayOf(
            0x02,
            (0xF0 and 0xFF).toByte(),
            0x03,
            0x63,
            0x6F,
            0x72,
            0x72,
            0x65,
            0x63,
            0x74,
            0x03
        )

    val btFail =
        byteArrayOf(
            0x02,
            (0xF0 and 0xFF).toByte(),
            0x03,
            0x6D,
            0x69,
            0x73,
            0x74,
            0x61,
            0x6B,
            0x65,
            0x03
        )


    val btClean =
        byteArrayOf(
            0x02,
            (0xF0 and 0xFF).toByte(),
            0x03,
            0x43,
            0x4C,
            0x53,
            0x03
        )


    val UART_SERVICE_UUID: UUID = UUID.fromString("6E400001-B5A3-F393-E0A9-E50E24DCCA9E")
    val UART_RX_CHARACTERISTIC_UUID: UUID = UUID.fromString("6E400002-B5A3-F393-E0A9-E50E24DCCA9E")
    val UART_TX_CHARACTERISTIC_UUID: UUID = UUID.fromString("6E400003-B5A3-F393-E0A9-E50E24DCCA9E")

    val BATTERY_SERVICE_UUID: UUID = UUID.fromString("0000180F-0000-1000-8000-00805f9b34fb")
    val BATTERY_LEVEL_CHARACTERISTIC_UUID: UUID =
        UUID.fromString("00002A19-0000-1000-8000-00805f9b34fb")
}