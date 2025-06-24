package id.my.sendiko.kinnect.auth.register.data

import id.my.sendiko.kinnect.auth.core.data.UserDao
import id.my.sendiko.kinnect.auth.core.data.UserEntity
import id.my.sendiko.kinnect.auth.core.domain.RegisterRepository
import id.my.sendiko.kinnect.auth.core.domain.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RegisterRepositoryImpl(
    private val dao: UserDao
): RegisterRepository {
    override suspend fun selectAllUsers(): Flow<List<User>> {
        val result = dao.selectAllUsers().map { list ->
            list.map { userEntity ->
                User(
                    fullName = userEntity.fullName,
                    email = userEntity.email,
                    age = userEntity.age,
                    password = userEntity.password,
                    latitude = userEntity.latitude,
                    longitude = userEntity.longitude
                )
            }
        }
        return result
    }

    override suspend fun insertUser(user: User) {
        val entity = UserEntity(
            fullName = user.fullName,
            email = user.email,
            age = user.age,
            password = user.password,
            latitude = user.latitude,
            longitude = user.longitude
        )
        dao.insertUser(entity)
    }
}