package id.my.sendiko.kinnect.auth.register.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {

    private val _state = MutableStateFlow(RegisterState())
    val state = _state.asStateFlow()

    fun onEvent(event: RegisterEvent) {
        when(event) {
            is RegisterEvent.OnFullNameChanged -> changeFullName(event.fullName)
            is RegisterEvent.OnEmailChanged -> changeEmail(event.email)
            is RegisterEvent.OnAgeChanged -> changeAge(event.age)
            is RegisterEvent.OnPasswordChanged -> changePassword(event.password)
            is RegisterEvent.OnPasswordVisibilityChanged -> changePasswordVisibility(event.visible)
            RegisterEvent.OnRegisterClicked -> register()
        }
    }

    private fun changeFullName(fullName: String) {
        _state.update { it.copy(fullName = fullName) }
    }

    private fun changeEmail(email: String) {
        _state.update { it.copy(email = email) }
    }

    private fun changeAge(age: String) {
        _state.update { it.copy(age = age.toInt()) }
    }

    private fun changePassword(password: String) {
        _state.update { it.copy(password = password) }
    }

    private fun changePasswordVisibility(visible: Boolean) {
        _state.update { it.copy(passwordVisible = visible) }
    }

    private fun register() {

    }
}