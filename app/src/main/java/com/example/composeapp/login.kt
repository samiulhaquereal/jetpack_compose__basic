package com.example.composeapp

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.*

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController? = null,
    name: String = "Guest"
) {
    val context = LocalContext.current
    var email by remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Compose App") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            Toast.makeText(context, "Drawer ✅", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Icon(
                            Icons.Filled.Menu, contentDescription = "menu"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            Toast.makeText(context, "Notification ✅", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Icon(
                            Icons.Filled.Notifications, contentDescription = "notification"
                        )
                    }
                    IconButton(
                        onClick = {
                            Toast.makeText(context, "Search ✅", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Icon(
                            Icons.Filled.Search, contentDescription = "search"
                        )
                    }
                },

                )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // ⬅️ Safe area padding applied here
                .padding(16.dp),
        ) {
            Box(
                modifier = Modifier
                    .padding(12.dp) // acts like margin
                    .size(width = 120.dp, height = 60.dp)
                    .background(
                        color = Color.Gray,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(8.dp), // inner padding
                contentAlignment = Alignment.Center
            ) {
                Text("Hi! $name", style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ))
            }
            Spacer(modifier = Modifier.height(10.dp))
            CustomTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email",
                placeholder = "Enter your email",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
