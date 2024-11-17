package com.nakulshah

class LetsKotlin constructor(val name: String, var message: String) {
    fun lets(): Unit
    {
        this.message = "Let's Kotlin, $name!"
    }
}