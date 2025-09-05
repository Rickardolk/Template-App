package com.example.templateapp.view.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CartScreen(
    modifier: Modifier = Modifier
) {

    Box(
        modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Cart",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
    }
}