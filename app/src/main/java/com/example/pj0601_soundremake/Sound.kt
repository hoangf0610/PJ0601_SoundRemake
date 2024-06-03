package com.example.pj0601_soundremake

class Sound(
    val index: Int,
    var sound: Int, var icon: Int, var name: Int,
    var isSelected: Boolean = false,
    var onFlash: Boolean = false,
    var onVibration: Boolean = false, var onSound: Boolean = false,
    var volumn: Int = 0,
    var duration: String = "15s"
)  {
}