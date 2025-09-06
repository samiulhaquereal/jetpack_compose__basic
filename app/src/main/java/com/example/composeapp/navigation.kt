package com.example.composeapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyAppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.mainScreen) {
        composable(Routes.mainScreen) {
            SafeAreaScaffold(navController)
        }
        composable(Routes.loginScreen+"/{name}") {
            val name = it.arguments?.getString("name")
            LoginScreen(navController,"$name")
        }
    }
}