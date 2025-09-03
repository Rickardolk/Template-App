package com.example.templateapp.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class ForgotPasswordViewModel : ViewModel() {
    private val autRef = FirebaseAuth.getInstance()

    fun forgotPass (
        email: String,
        context: Context
    ) {
        viewModelScope.launch {
            if ( email.isNotEmpty()) {
                autRef.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                context,
                                "Periksa email anda untuk mereset password",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    .addOnFailureListener {
                        Toast.makeText(
                            context,
                            "Email tidak terdaftar",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            } else {
                Toast.makeText(
                    context,
                    "Kolom tidak boleh kosong",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}