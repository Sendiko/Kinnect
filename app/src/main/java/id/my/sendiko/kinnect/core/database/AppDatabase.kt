package id.my.sendiko.kinnect.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import id.my.sendiko.kinnect.auth.core.data.UserDao
import id.my.sendiko.kinnect.auth.core.data.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase: RoomDatabase() {
    abstract val userDao: UserDao
}