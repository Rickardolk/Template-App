package com.example.templateapp.screen.splashscreen

import android.content.Intent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.templateapp.MainActivity
import com.example.templateapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen() {
    val context = LocalContext.current
    var startActivity by remember { mutableStateOf(false) }

    val alphaAnim = animateFloatAsState(
        targetValue = if (startActivity) 1f else 0f,
        animationSpec = tween(1000) ,
        label = ""
    )

    LaunchedEffect(key1 = true) {
        startActivity = true
        delay(3000)
        context.startActivity(Intent(context, MainActivity::class.java))
        (context as? MainActivity)?.finish()
    }

    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(
    modifier: Modifier = Modifier,
    alpha : Float
) {
    Box(
        modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colorResource(R.color.ocean_boat_blue) ,
                        colorResource(R.color.rich_black)
                    )
                )
            )
    ) {
        Column(
            modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_big_logo) ,
                contentDescription = "ic your logo here",
                modifier = Modifier
                    .size(140.dp)
                    .alpha(alpha)
            )

            Spacer(modifier.height(100.dp))
            Text(
                text = "Create your dream Apps with us!",
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        }
    }

}

//@Preview
//@Composable
//private fun View() {
//    Splash()
//
//}