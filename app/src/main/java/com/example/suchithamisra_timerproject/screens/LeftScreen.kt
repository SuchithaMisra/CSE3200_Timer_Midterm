package com.example.suchithamisra_timerproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.suchithamisra_timerproject.timers.LeftScreenViewModel

@Composable
//Computations for timer
private fun formatElapsedTime(elapsedTime: Long): String {
    var elapsedSeconds = elapsedTime
    var hours: Long = 0
    var minutes: Long = 0
    var seconds: Long = 0
    if (elapsedSeconds >= 3600) {
        hours = elapsedSeconds / 3600
        elapsedSeconds -= hours * 3600
    }
    if (elapsedSeconds >= 60) {
        minutes = elapsedSeconds / 60
        elapsedSeconds -= minutes * 60
    }
    seconds = elapsedSeconds
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}

@Composable
fun LeftScreen(name: String, myViewModel: LeftScreenViewModel) {
    val elapsedTime by myViewModel.timePassed()
    val isRunning by myViewModel.getRunningState() // Use getRunningState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFEFB8C8), shape = CircleShape)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(formatElapsedTime(elapsedTime), fontSize = 60.sp)
            Spacer(modifier = Modifier.padding(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { myViewModel.startTimer() }) {
                    Text("Start")
                }
                Spacer(modifier = Modifier.padding(15.dp))
                Button(onClick = { myViewModel.stopTimer() }) {
                    Text(if (isRunning) "Pause" else "Stop") // Change button text based on isRunning state
                }
                Spacer(modifier = Modifier.padding(15.dp))
                Button(onClick = { myViewModel.restartTimer() }) {
                    Text("Redo")
                }
            }
        }
    }
}