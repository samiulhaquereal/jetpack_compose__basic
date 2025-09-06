package com.example.composeapp

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapp.ui.components.AppDrawerContent
import com.example.composeapp.ui.components.AppScaffold

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController? = null,
    name: String = "Guest",
    vm: LoginViewModel = viewModel()
) {
    val context = LocalContext.current
    val uiState by vm.uiState.collectAsState()

    // Collect one-shot events (Toast messages)
    LaunchedEffect(Unit) {
        vm.events.collect { msg ->
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }

    AppScaffold(
        title = "My Compose App",
        drawerContent = {
            AppDrawerContent(
                onProfileClick = { /* navController?.navigate("profile") */ },
                onSettingsClick = { /* navController?.navigate("setting") */ }
            )
        },
        onNotificationClick = { Toast.makeText(context, "Notification ✅", Toast.LENGTH_SHORT).show() },
        onSearchClick = { Toast.makeText(context, "Search ✅", Toast.LENGTH_SHORT).show() }
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
        ) {
            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .size(width = 120.dp, height = 60.dp)
                    .background(
                        color = Color.Gray,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Hi! $name",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            CustomTextField(
                value = uiState.email,
                onValueChange = { value ->
                    vm.onEmailChanged(value)  // 👈 the new text comes from the TextField
                },
                label = "Email",
                placeholder = "Enter your email",
                modifier = Modifier.padding(16.dp)
            )
            CustomTextField(
                value = uiState.password,
                isPassword = true,
                onValueChange = vm::onPasswordChanged,
                label = "Password",
                placeholder = "Enter your Password",
                modifier = Modifier.padding(16.dp)
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = vm::onLoginClicked
                ) {
                    Text("Login")
                }
            }
        }
    }
}
