package com.example.templateapp.view.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Home",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )

        Button(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Default.ExitToApp,
                contentDescription = "ic logout"
            )
        }
    }
}