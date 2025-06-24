package id.my.sendiko.kinnect.core.di

import id.my.sendiko.kinnect.auth.core.data.UserDao
import id.my.sendiko.kinnect.core.database.AppDatabase

interface Modules {

    val database: AppDatabase

    val userDao: UserDao

}