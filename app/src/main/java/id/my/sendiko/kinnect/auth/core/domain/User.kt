package id.my.sendiko.kinnect.auth.core.domain

data class User(
    val fullName: String,
    val email: String,
    val age: Int,
    val password: String,
    val latitude: Double,
    val longitude: Double,
)
