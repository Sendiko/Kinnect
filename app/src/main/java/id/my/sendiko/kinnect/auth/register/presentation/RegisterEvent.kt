package id.my.sendiko.kinnect.auth.register.presentation

sealed interface RegisterEvent {
    data class OnFullNameChanged(val fullName: String): RegisterEvent
    data class OnEmailChanged(val email: String): RegisterEvent
    data class OnAgeChanged(val age: String): RegisterEvent
    data class OnPasswordChanged(val password: String): RegisterEvent
    data class OnPasswordVisibilityChanged(val visible: Boolean): RegisterEvent
    data class OnSaveLocation(val latitude: Double, val longitude: Double): RegisterEvent
    data class OnPermissionGranted(val granted: Boolean): RegisterEvent
    data class OnShowMessage(val message: String): RegisterEvent
    data object OnRegisterClicked: RegisterEvent
}
