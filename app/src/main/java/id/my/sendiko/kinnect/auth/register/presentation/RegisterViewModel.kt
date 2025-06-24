package id.my.sendiko.kinnect.auth.register.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.my.sendiko.kinnect.auth.core.domain.RegisterRepository
import id.my.sendiko.kinnect.auth.core.domain.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val repository: RegisterRepository
) : ViewModel() {

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
        _state.update { it.copy(age = age) }
    }

    private fun changePassword(password: String) {
        _state.update { it.copy(password = password) }
    }

    private fun changePasswordVisibility(visible: Boolean) {
        _state.update { it.copy(passwordVisible = visible) }
    }

    private fun register() {
        viewModelScope.launch {
            repository.selectAllUsers().collect {
                val newUsers = User(
                    fullName = state.value.fullName,
                    email = state.value.email,
                    age = state.value.age.toInt(),
                    password = state.value.password,
                    latitude = state.value.latitude,
                    longitude = state.value.longitude
                )
                if (it.contains(newUsers)) {
                    _state.update { it.copy(message = "User already exists.") }
                } else {
                    repository.insertUser(newUsers)
                    _state.update { it.copy(message = "User registered successfully.") }
                }
            }
        }
    }
}