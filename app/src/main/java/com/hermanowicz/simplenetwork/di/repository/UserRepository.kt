package com.hermanowicz.simplenetwork.di.repository

import com.hermanowicz.simplenetwork.data.model.User
import com.hermanowicz.simplenetwork.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

interface UserRepository {
    suspend fun fetchUserList(): List<User>
    suspend fun fetchUserById(id: Int): User
    suspend fun registerUser() : String
}

@Module
@InstallIn(SingletonComponent::class)
abstract class UserRepositoryModule {

    @Binds
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository
}
