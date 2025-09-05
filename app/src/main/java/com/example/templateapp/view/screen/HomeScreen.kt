package com.example.templateapp.view.screen

import android.graphics.SumPathEffect
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.templateapp.R
import com.example.templateapp.view.component.PopularButton
import com.example.templateapp.view.component.SearchBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(top = 34.dp)
        ) {
            Row(
                modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Hi, User👋🏻",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(R.color.onyx_black)
                    )

                    Text(
                        text = "Create your apps",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(R.color.old_silver)
                    )
                }

                Image(
                    painter = painterResource(R.drawable.ic_profile_aneh),
                    contentDescription = "ic profile",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop

                )

            }

            Spacer(modifier.height(24.dp))
            SearchBar()

            Spacer(modifier.height(16.dp))
            Row(
                modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) { 
                Text(
                    text = "Popular",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.rich_black)
                )

                TextButton(
                    onClick = {}
                ) {
                    Text(
                        text = "View all",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(R.color.old_silver)
                    )
                }
            }

            PopularButton {  }
        }
    }
}

@Preview
@Composable
private fun View() {
    HomeScreen()
}