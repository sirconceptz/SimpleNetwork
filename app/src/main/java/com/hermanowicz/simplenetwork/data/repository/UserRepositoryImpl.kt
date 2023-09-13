package com.hermanowicz.simplenetwork.data.repository

import com.hermanowicz.simplenetwork.data.model.User
import com.hermanowicz.simplenetwork.di.remote.dataSource.UserRemoteDataSource
import com.hermanowicz.simplenetwork.di.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {
    override suspend fun fetchUserList(): List<User> {
        return userRemoteDataSource.fetchUserList()
    }

    override suspend fun fetchUserById(id: Int): User {
        return userRemoteDataSource.fetchUserById(id)
    }

    override suspend fun registerUser(): String {
        return userRemoteDataSource.registerUser()
    }

}