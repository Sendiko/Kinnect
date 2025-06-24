package id.my.sendiko.kinnect.auth.core.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val fullName: String,
    val email: String,
    val age: Int,
    val password: String,
    val latitude: Double,
    val longitude: Double,
)