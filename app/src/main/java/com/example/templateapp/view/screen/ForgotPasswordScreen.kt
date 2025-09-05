package com.example.templateapp.view.screen

import android.content.Context
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.graphics.Color
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
import com.example.templateapp.viewmodel.ForgotPasswordViewModel

@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    forgotPasswordViewModel: ForgotPasswordViewModel = viewModel(),
    context: Context
) {
    var email by remember { mutableStateOf("") }

    Box(
        modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier
                .fillMaxWidth()
                .padding(top = 116.dp)
                .padding(horizontal = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(R.drawable.ic_small_logo),
                contentDescription = "ic logo small",
                modifier = Modifier.size(80.dp)
            )

            Text(
                text = "Welcome to Template App",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(150.dp))

            Column(
                modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Register" ,
                    fontSize = 24.sp ,
                    fontWeight = FontWeight.Medium ,
                    color = Color.DarkGray
                )

                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "ic email",
                        )
                    },
                    label = {
                        Text(
                            text = "Email"
                        )
                    },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(R.color.ocean_boat_blue),
                        unfocusedBorderColor = Color.DarkGray,
                        focusedTextColor = colorResource(R.color.ocean_boat_blue),
                        unfocusedTextColor = Color.DarkGray,
                        focusedLabelColor = colorResource(R.color.ocean_boat_blue),
                        unfocusedLabelColor = Color.DarkGray,
                        focusedLeadingIconColor = colorResource(R.color.ocean_boat_blue),
                        unfocusedLeadingIconColor = Color.DarkGray,
                        cursorColor = colorResource(R.color.ocean_boat_blue)
                    )
                )

                Spacer(modifier.height(24.dp))
                Button(
                    onClick = { forgotPasswordViewModel.forgotPass(email, context)},
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.ocean_boat_blue)
                    )
                ) {
                    Text(
                        text = "Forgot Password",
                        fontSize = 20.sp
                    )
                }

                Row(
                    modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(
                        onClick = { navController.navigate("login") }
                    ) {
                        Text(
                            text = "Back",
                            color = colorResource(R.color.ocean_boat_blue)
                        )
                    }
                }



            }

        }
    }
}

//@Preview
//@Composable
//private fun View() {
//    ForgotPasswordScreen()
//
//}