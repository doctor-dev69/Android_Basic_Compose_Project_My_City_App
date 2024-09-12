package com.example.myhazro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.myhazro.ui.theme.AttockCity
import com.example.myhazro.ui.theme.MyHazroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyHazroTheme {
                AttockCity()
            }
        }
    }
}

