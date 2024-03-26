package com.example.suchithamisra_timerproject
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.suchithamisra_timerproject.timers.CenterScreenViewModel
import com.example.suchithamisra_timerproject.timers.LeftScreenViewModel
import com.example.suchithamisra_timerproject.timers.RightScreenViewModel

class MainActivity : ComponentActivity() {

    private val leftViewModel : LeftScreenViewModel by viewModels<LeftScreenViewModel>()
    private val rightViewModel : RightScreenViewModel by viewModels<RightScreenViewModel>()
    private val centerViewModel : CenterScreenViewModel by viewModels<CenterScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Navigation(leftViewModel, centerViewModel, rightViewModel)
            }
        }
    }
}