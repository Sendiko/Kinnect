package id.my.sendiko.kinnect.auth.register.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {

    private val _state = MutableStateFlow(RegisterState())
    val state = _state.asStateFlow()

    fun onEvent(event: RegisterEvent) {
        when(event) {
            is RegisterEvent.OnSaveLocation -> saveGeoLocation(event.latitude, event.longitude)
            is RegisterEvent.OnFullNameChanged -> changeFullName(event.fullName)
            is RegisterEvent.OnEmailChanged -> changeEmail(event.email)
            is RegisterEvent.OnAgeChanged -> changeAge(event.age)
            is RegisterEvent.OnPasswordChanged -> changePassword(event.password)
            is RegisterEvent.OnPasswordVisibilityChanged -> changePasswordVisibility(event.visible)
            is RegisterEvent.OnPermissionGranted -> grantPermission(event.granted)
            is RegisterEvent.OnShowMessage -> showMessage(event.message)
            RegisterEvent.OnRegisterClicked -> register()
        }
    }

    private fun showMessage(message: String) {
        _state.update { it.copy(message = message) }
    }

    private fun grantPermission(granted: Boolean) {
        _state.update { it.copy(isPermissionGranted = granted) }
    }

    private fun saveGeoLocation(latitude: Double, longitude: Double) {
        _state.update { it.copy(latitude = latitude, longitude = longitude, message = "Location granted.") }
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