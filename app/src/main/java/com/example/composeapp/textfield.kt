package com.example.composeapp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "",
    placeholder: String = "",
    singleLine: Boolean = true
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { if (label.isNotEmpty()) Text(label) },
        placeholder = { if (placeholder.isNotEmpty()) Text(placeholder) },
        modifier = modifier.fillMaxWidth(),
        singleLine = singleLine
    )
}
