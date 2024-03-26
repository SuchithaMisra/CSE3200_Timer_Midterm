package com.example.suchithamisra_timerproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize().padding(horizontal = 50.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
                .background(
                    color = Color(0xF08BBBD1),
                    shape = RoundedCornerShape(16.dp)
                )
                .drawBehind {
                    val shadowColor = Color.Gray.copy(alpha = 0.3f)
                    val offsetY = 2.dp.toPx()
                    val cornerRadius = 16.dp.toPx()
                    val brush = Brush.verticalGradient(
                        0f to shadowColor,
                        offsetY to Color.Transparent
                    )
                    drawIntoCanvas {
                        drawRoundRect(
                            brush = brush,
                            topLeft = Offset(0f, 0f),
                            size = Size(size.width, size.height),
                            //cornerRadius = cornerRadius
                        )
                    }
                }
                .shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 40.dp) // Adjust vertical padding here
            ) {
                Button(onClick = {
                    navController.navigate(ScreenDirection.LeftScreen.route)
                }) {
                    Text("View First screen")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    navController.navigate(ScreenDirection.CenterScreen.route)
                }) {
                    Text("View Second screen")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    navController.navigate(ScreenDirection.RightScreen.route)
                }) {
                    Text("View Third screen")
                }
            }
        }
    }
}