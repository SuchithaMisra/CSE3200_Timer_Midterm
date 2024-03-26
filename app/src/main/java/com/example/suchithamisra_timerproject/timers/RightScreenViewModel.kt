package com.example.suchithamisra_timerproject.timers

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RightScreenViewModel : ViewModel() {
    private var job: Job? = null //Job used for managing asynchronous tasks in Kotlin Library
    private var elapsedTime = mutableStateOf(0L)
    private var current = mutableStateOf(false) // Corrected variable name

    init {
        // Start the coroutine job to update elapsedTime
        job = viewModelScope.launch {
            while (true) {
                if (current.value) { // Corrected variable name
                    elapsedTime.value++
                }
                delay(1000)
            }
        }
    }
    fun startTimer() {
        current.value = true // Corrected variable name
    }
    fun stopTimer() {
        current.value = false // Corrected variable name
    }
    fun restartTimer() {
        current.value = false // Corrected variable name
        elapsedTime.value = 0L
    }
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
    fun timePassed(): State<Long> = elapsedTime

    fun getRunningState(): State<Boolean> = current
}