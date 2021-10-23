package com.example.taskproject.utils

object GenerateOTP {

    fun createFourDigitNumber(): String {
        val numbers: MutableList<Int> = ArrayList()
        for (i in 0..9) numbers.add(i)
        numbers.shuffle()

        var result = ""
        for (i in 0..3) {
            result += numbers[i]
        }
        return result
    }
}