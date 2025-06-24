package id.my.sendiko.kinnect.auth.register.presentation

data class RegisterState(
    val fullName: String = "",
    val email: String = "",
    val age: Int = 0,
    val password: String = "",
    val passwordVisible: Boolean = false,
    val message: String = "",
    val isSuccess: Boolean = false,
    val location: String = ""
)
