package com.example.evaluaciondos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.evaluaciondos.navigation.AppNavigation
import com.example.evaluaciondos.ui.ui.theme.EvaluacionDosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EvaluacionDosTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ){
                    AppNavigation()
                }
            }
        }
    }
}

