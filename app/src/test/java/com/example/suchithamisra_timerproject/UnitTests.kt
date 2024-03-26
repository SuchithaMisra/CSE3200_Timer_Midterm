package com.example.suchithamisra_timerproject

import org.junit.Assert.assertEquals
import org.junit.Test


fun formatElapsedTime(elapsedTime: Long): String {

    // Break the elapsed seconds into hours, minutes, and seconds.
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

class Test {

    @Test
    fun test1() {
        assertEquals("00:00:00", formatElapsedTime(0))
    }
    @Test
    fun test2() {
        assertEquals("00:00:35", formatElapsedTime(35))
    }
    @Test
    fun test3() {
        assertEquals("00:03:00", formatElapsedTime(180))
    }
    @Test
    fun test4() {
        assertEquals("01:00:00", formatElapsedTime(3600))
    }
    @Test
    fun test5() {
        assertEquals("01:01:00", formatElapsedTime(3660))
    }
    @Test
    fun test6() {
        assertEquals("24:00:00", formatElapsedTime(86400))
    }
}

