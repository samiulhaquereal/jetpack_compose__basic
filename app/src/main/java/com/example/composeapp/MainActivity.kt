package com.example.composeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.ui.theme.Purple40
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main") {
                composable("main") {
                    SafeAreaScaffold(
                        onNavigateToLogin = { navController.navigate("login") }
                    )
                }
                composable("login") { LoginScreen(onNavigateBack = { navController.popBackStack() }) }
            }
            //ColumnComponent()
            //TextComponent()
            //TextComponent("Welcome")
            //SafeAreaScaffold()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview(){
        SafeAreaScaffold(
            onNavigateToLogin = { /* no-op for preview */ }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SafeAreaScaffold(onNavigateToLogin: ()-> Unit) {
        val context = LocalContext.current
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
            floatingActionButton = {
               FloatingActionButton(
                   onClick = {
                       Toast.makeText(context, "Floating button ✅", Toast.LENGTH_SHORT).show()
                   }
               ) {
                   Icon(Icons.Filled.Add, contentDescription = "add")
               }
            },
            bottomBar = {
                BottomAppBar {
                    Text(
                        text = "Bottom Bar",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding) // ⬅️ Safe area padding applied here
                    .padding(16.dp),       // Extra padding inside
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Hello, world!")
                Spacer(modifier = Modifier.height(20.dp))
                Text("This text won’t be cut by the status bar ✅")
                Text("And it respects bottom nav safe area too 🎉")
                Button(
                    onClick = {
                        Toast.makeText(context, "Done ✅", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Text("Click here")
                }
                Spacer(modifier = Modifier.height(20.dp))
                ShowSwitch()
                Button(
                    onClick = {
                        onNavigateToLogin()
                    }
                ) {
                    Text("Login Page ->")
                }
            }
        }
    }

    @Composable
    fun ColumnComponent(){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp), // space between texts
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Real")
            Text("Binty")
        }
    }

    @Composable
    fun TextComponent(value: String){
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color.LightGray)
                .padding(18.dp),
            text = "Binty $value",
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            color = Color.Black,
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Black
            )
        )
    }

    @Composable
    fun ShowSwitch(){
        print("Real")
        val isChecked = remember {
            mutableStateOf(value = true)
        }
        Switch(
            modifier = Modifier.run{
                padding(10.dp)
            },
            checked = isChecked.value,
            onCheckedChange = {
                isChecked.value = it
            },
        )
    }

}