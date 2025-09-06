// LoginViewModel.kt
package com.example.composeapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class LoginUiState(
    val email: String = "",
    val password: String = ""
)

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    // For one-shot Toast messages
    private val _events = Channel<String>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    fun onEmailChanged(newEmail: String) {
        _uiState.value = _uiState.value.copy(email = newEmail)
    }

    fun onPasswordChanged(newPassword: String) {
        _uiState.value = _uiState.value.copy(password = newPassword)
    }

    fun onLoginClicked() {
        val (email, password) = _uiState.value
        when {
            email.isBlank() || password.isBlank() ->
                sendEvent("Input the email and password")
            email == "real" && password == "123" ->
                sendEvent("Successfully logged in ✅")
            else ->
                sendEvent("Email and Password are wrong")
        }
    }

    private fun sendEvent(msg: String) {
        viewModelScope.launch {
            _events.send(msg)
        }
    }
}
