package com.example.suchithamisra_timerproject.timers

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CenterScreenViewModel : ViewModel() {
    private var job: Job? = null //Job used for managing asynchronous tasks in Kotlin Library
    private var elapsedTime = mutableStateOf(0L)
    private var curent = mutableStateOf(false)

    init {
        job = viewModelScope.launch {
            while (true) {
                if (curent.value) {
                    elapsedTime.value++
                }
                delay(1000)
            }
        }
    }

    fun startTimer() {
        curent.value = true
    }
    fun stopTimer() {
        curent.value = false
    }
    fun restartTimer() {
        curent.value = false
        elapsedTime.value = 0L
    }
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
    fun timePassed(): State<Long> = elapsedTime

    fun getRunningState(): State<Boolean> = curent
}
