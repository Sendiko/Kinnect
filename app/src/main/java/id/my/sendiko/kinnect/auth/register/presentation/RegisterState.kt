package id.my.sendiko.kinnect.auth.register.presentation

data class RegisterState(
    val fullName: String = "",
    val email: String = "",
    val age: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false,
    val message: String = "",
    val isSuccess: Boolean = false,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val isPermissionGranted: Boolean = false
)
