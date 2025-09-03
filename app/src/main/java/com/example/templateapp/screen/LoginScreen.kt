package com.example.templateapp.screen

import android.content.Context
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.templateapp.R
import com.example.templateapp.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController : NavController,
    loginViewModel: LoginViewModel = viewModel(),
    context: Context
) {
    var email by remember { mutableStateOf("") }
    var password by remember {mutableStateOf("")}

    Box(
        modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp)
                .padding(top = 116.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(R.drawable.ic_small_logo),
                contentDescription = "ic logo small",
                modifier = Modifier
                    .size(80.dp)
            )

            Text(
                text = "Welcome to Template App" ,
                fontSize = 16.sp ,
                fontWeight = FontWeight.Medium,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(150.dp))

            Column(
                modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Login" ,
                    fontSize = 24.sp ,
                    fontWeight = FontWeight.Medium ,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = email ,
                    onValueChange = { email = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(20.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "ic email"
                        )
                    },
                    label = {
                        Text(
                            text = "Email"
                        )
                    },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = colorResource(R.color.ocean_boat_blue),
                        unfocusedTextColor = Color.DarkGray,
                        focusedLabelColor = colorResource(R.color.ocean_boat_blue),
                        unfocusedLabelColor = Color.DarkGray,
                        focusedBorderColor = colorResource(R.color.ocean_boat_blue),
                        unfocusedBorderColor = Color.DarkGray,
                        focusedLeadingIconColor = colorResource(R.color.ocean_boat_blue),
                        unfocusedLeadingIconColor = Color.DarkGray,
                        cursorColor = colorResource(R.color.ocean_boat_blue)
                    )

                )

                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = {password = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(20.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "ic password"
                        )
                    },
                    label = {
                        Text(
                            text = "Password"
                        )
                    },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = colorResource(R.color.ocean_boat_blue),
                        unfocusedTextColor = Color.DarkGray,
                        focusedLabelColor = colorResource(R.color.ocean_boat_blue),
                        unfocusedLabelColor = Color.DarkGray,
                        focusedBorderColor = colorResource(R.color.ocean_boat_blue),
                        unfocusedBorderColor = Color.DarkGray,
                        focusedLeadingIconColor = colorResource(R.color.ocean_boat_blue),
                        unfocusedLeadingIconColor = Color.DarkGray,
                        cursorColor = colorResource(R.color.ocean_boat_blue)
                    )
                )

                Column(
                    modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    TextButton(
                        onClick = { navController.navigate("forgot password")},
                    ) {
                        Text(
                            text = "Forgot password",
                            color = colorResource(R.color.ocean_boat_blue)
                        )
                    }
                }

                Button(
                    onClick = { loginViewModel.login(email, password, context, navController)},
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.ocean_boat_blue)
                    )
                ) {
                    Text(
                        text = "Login",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                }

                Row(
                    modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(
                        onClick = { navController.navigate("register")}
                    ) {
                        Text(
                            text = "Register",
                            color = colorResource(R.color.ocean_boat_blue)
                        )
                    }

                    Text(
                        text = "if you don't have an account yet",
                        color = Color.DarkGray
                    )
                }
            }
        }
    }

}

//@Preview
//@Composable
//private fun View() {
//    LoginScreen()
//}