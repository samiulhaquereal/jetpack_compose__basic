// AppTopBar.kt
package com.example.composeapp.ui.components

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String = "My Compose App",
    onMenuClick: (() -> Unit)? = null,
    onNotificationClick: (() -> Unit)? = null,
    onSearchClick: (() -> Unit)? = null
) {
    val context = LocalContext.current

    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(
                onClick = {
                    onMenuClick?.invoke()
                        ?: Toast.makeText(context, "Drawer ✅", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(Icons.Filled.Menu, contentDescription = "menu")
            }
        },
        actions = {
            IconButton(
                onClick = {
                    onNotificationClick?.invoke()
                        ?: Toast.makeText(context, "Notification ✅", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(Icons.Filled.Notifications, contentDescription = "notification")
            }

            IconButton(
                onClick = {
                    onSearchClick?.invoke()
                        ?: Toast.makeText(context, "Search ✅", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(Icons.Filled.Search, contentDescription = "search")
            }
        }
    )
}
