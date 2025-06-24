package id.my.sendiko.kinnect.core.di

import android.app.Application
import androidx.room.Room
import id.my.sendiko.kinnect.auth.core.data.UserDao
import id.my.sendiko.kinnect.core.database.AppDatabase

class AppModule(
    private val app: Application
): Modules {
    override val database: AppDatabase
        get() = Room
            .databaseBuilder(
                app.applicationContext,
                AppDatabase::class.java,
                "kinnect.db"
            )
            .build()

    override val userDao: UserDao
        get() = database.userDao
}