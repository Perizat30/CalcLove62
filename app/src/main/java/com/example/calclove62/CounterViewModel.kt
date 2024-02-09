package com.example.calclove62

import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    var number: Int = 0

    fun increment() {
        number++
    }

    fun decrement() {
        number--
    }
}
