package com.hafidmust.livedataapi

open class Event<out T>(private val content : T) {
    var haseBeenHandled = false
    private set

    fun getContentIfNotHandled() : T?{
        return if (haseBeenHandled){
            null
        }else{
            haseBeenHandled = true
            content
        }
    }

    fun peekContent() : T = content

}