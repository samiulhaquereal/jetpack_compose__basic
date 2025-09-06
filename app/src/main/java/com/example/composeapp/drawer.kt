// AppDrawerContent.kt
package com.example.composeapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppDrawerContent(
    onProfileClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {}
) {
    ModalDrawerSheet {
        Text("Drawer Menu", modifier = Modifier.padding(16.dp))
        Divider()
        NavigationDrawerItem(
            label = { Text("Profile") },
            selected = false,
            onClick = onProfileClick
        )
        NavigationDrawerItem(
            label = { Text("Setting") },
            selected = false,
            onClick = onSettingsClick
        )
    }
}
