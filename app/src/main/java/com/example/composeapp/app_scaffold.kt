// AppScaffold.kt
package com.example.composeapp.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    title: String,
    drawerContent: @Composable () -> Unit,
    onNotificationClick: (() -> Unit)? = null,
    onSearchClick: (() -> Unit)? = null,
    content: @Composable (innerPadding: PaddingValues) -> Unit // 👈 use PaddingValues
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { drawerContent() }
    ) {
        Scaffold(
            topBar = {
                AppTopBar(
                    title = title,
                    onMenuClick = { scope.launch { drawerState.open() } },
                    onNotificationClick = onNotificationClick,
                    onSearchClick = onSearchClick
                )
            }
        ) { innerPadding: PaddingValues ->
            content(innerPadding)
        }
    }
}
