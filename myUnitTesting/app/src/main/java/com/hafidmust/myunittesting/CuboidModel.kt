package com.hafidmust.myunittesting

class CuboidModel {
    private var width = 0.0
    private var length = 0.0
    private var height = 0.0

    fun getVolume() : Double = width * length * height

    fun getSurfaceArea() : Double{
        val wl = width * length
        val wh = width * height
        val lh = length * height

        return 2 * (wl + wh + lh)
    }

    fun getCircumference() : Double = 4 * (width + length + height)

    fun save(w : Double, l : Double, h : Double){
        width = w
        length = l
        height = h
    }
}