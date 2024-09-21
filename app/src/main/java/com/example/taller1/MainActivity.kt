package com.example.taller1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taller1.ui.theme.Taller1Theme
import android.content.Intent
import com.example.taller1.ui.theme.SettingsActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import com.example.taller1.ui.theme.AppViewModel



class MainActivity : ComponentActivity() {
    private val viewModel: AppViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(onNavigateToSettings = {
                startActivity(Intent(this, SettingsActivity::class.java))
            }, viewModel = viewModel)
        }
    }
}

@Composable
fun MainScreen(onNavigateToSettings: () -> Unit, viewModel: AppViewModel) {
    var name by remember { mutableStateOf("") }
    var showSaveButton by remember { mutableStateOf(false) }
    var savedName by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxSize().background(viewModel.selectedBackgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = { name = it
                showSaveButton = it.isNotBlank()},
            label = { Text("Nombre") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        if (showSaveButton) {
            Button(onClick = {
                savedName = name
                showSaveButton = false
            }) {
                Text("Guardar")
            }
        }
        if (savedName.isNotBlank()) {
            Text("Nombre guardado: $savedName")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigateToSettings) {
            Text("Pasar a la siguiente página")
        }
    }
}
