package com.example.suchithamisra_timerproject.screens

open class ScreenDirection(val route: String) {
    object MainScreen: ScreenDirection("main_screen")
    object LeftScreen: ScreenDirection("left_screen")
    object CenterScreen: ScreenDirection("center_screen")
    object RightScreen: ScreenDirection("right_screen")
}
