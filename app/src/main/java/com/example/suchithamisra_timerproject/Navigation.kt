package com.example.suchithamisra_timerproject

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.suchithamisra_timerproject.screens.CenterScreen
import com.example.suchithamisra_timerproject.screens.LeftScreen
import com.example.suchithamisra_timerproject.screens.MainScreen
import com.example.suchithamisra_timerproject.screens.RightScreen
import com.example.suchithamisra_timerproject.screens.ScreenDirection
import com.example.suchithamisra_timerproject.timers.CenterScreenViewModel
import com.example.suchithamisra_timerproject.timers.LeftScreenViewModel
import com.example.suchithamisra_timerproject.timers.RightScreenViewModel

@Composable
fun Navigation(leftViewModel: LeftScreenViewModel, centerViewModel: CenterScreenViewModel, rightViewModel: RightScreenViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenDirection.MainScreen.route) {
        composable(route = ScreenDirection.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = ScreenDirection.LeftScreen.route) {
            LeftScreen(name = "LEFT", leftViewModel)
        }
        composable(route = ScreenDirection.CenterScreen.route) {
            CenterScreen(name = "LEFT", centerViewModel)
        }
        composable(route = ScreenDirection.RightScreen.route) {
            RightScreen(name = "RIGHT", rightViewModel)
        }
    }
}