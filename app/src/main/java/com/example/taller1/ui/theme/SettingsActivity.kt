package com.example.taller1.ui.theme

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.activity.viewModels
import androidx.compose.foundation.background



class AppViewModel : ViewModel() {
    var selectedBackgroundColor by mutableStateOf(Color.White)
}

class SettingsActivity : ComponentActivity() {
    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsScreen(onNavigateToStart = {
                startActivity(Intent(this, StartActivity::class.java))
            }, viewModel = viewModel)
        }
    }
}
@Composable
fun SettingsScreen(onNavigateToStart: () -> Unit, viewModel: AppViewModel) {
    Column(
        modifier = Modifier.fillMaxSize().background(viewModel.selectedBackgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ColorSelection(viewModel)

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigateToStart) {
            Text("Volver al inicio")
        }
    }
}
@Composable
fun ColorSelection(viewModel: AppViewModel) {
    /*var selectedColor by remember { mutableStateOf(Color.White) }*/

    Column {
        ColorButton(color = Color.Yellow, isSelected = viewModel.selectedBackgroundColor == Color.Yellow) {
            viewModel.selectedBackgroundColor = Color.Yellow
        }
        ColorButton(color = Color.LightGray, isSelected = viewModel.selectedBackgroundColor == Color.LightGray) {
            viewModel.selectedBackgroundColor = Color.LightGray
        }
        ColorButton(color = Color.Blue, isSelected = viewModel.selectedBackgroundColor == Color.Blue) {
            viewModel.selectedBackgroundColor = Color.Blue
        }
    }
}
@Composable
fun ColorButton(color: Color, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = if (isSelected) Color.White else Color.Black
        ),
        modifier = Modifier.padding(4.dp)
    ) {
        if (isSelected) {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "Selected",
                tint = Color.White
            )
        }
    }
}