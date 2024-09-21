package com.example.taller1.ui.theme

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.taller1.MainActivity
import java.time.LocalTime
import java.util.Calendar
import androidx.activity.compose.setContent
import androidx.activity.viewModels

class StartActivity : ComponentActivity() {
    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartScreen(onNavigateToMain = {
                startActivity(Intent(this, MainActivity::class.java))
            }, viewModel = viewModel)
        }
    }
}

@Composable
fun StartScreen(onNavigateToMain: () -> Unit, viewModel: AppViewModel) {
    val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    val greeting = when (currentHour) {
        in 0..11 -> "Buenos días"
        in 12..18 -> "Buenas tardes"
        else -> "Buenas noches"
    }

    Column(
        modifier = Modifier.fillMaxSize().background(viewModel.selectedBackgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$greeting",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigateToMain) {
            Text("Continuar")
        }
    }
}