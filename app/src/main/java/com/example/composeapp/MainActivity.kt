package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            //ColumnComponent()
            //TextComponent()
            //TextComponent("Welcome")
            SafeAreaScaffold()
        }
    }

    @Composable
    fun ColumnComponent(){
        Column(
            modifier = Modifier.fillMaxSize().padding(10.dp),
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
            modifier = Modifier.fillMaxWidth().height(80.dp).background(Color.LightGray).padding(18.dp),
            text = "Binty $value",
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            color = Color.Black
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview(){
        SafeAreaScaffold()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SafeAreaScaffold() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("My Compose App") }
                )
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
                Text("This text won’t be cut by the status bar ✅")
                Text("And it respects bottom nav safe area too 🎉")
            }
        }
    }

}