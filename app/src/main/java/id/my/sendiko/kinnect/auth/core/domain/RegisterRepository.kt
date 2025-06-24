package id.my.sendiko.kinnect.auth.core.domain

import kotlinx.coroutines.flow.Flow

interface RegisterRepository {

    suspend fun selectAllUsers(): Flow<List<User>>

    suspend fun insertUser(user: User)

}