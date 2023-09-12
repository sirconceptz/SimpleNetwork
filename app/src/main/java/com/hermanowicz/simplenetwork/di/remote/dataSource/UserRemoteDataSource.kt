package com.hermanowicz.simplenetwork.di.remote.dataSource

import com.hermanowicz.simplenetwork.data.model.User
import com.hermanowicz.simplenetwork.data.remote.dataSource.UserRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

interface UserRemoteDataSource {
    suspend fun fetchUserList(): List<User>
    suspend fun fetchUserById(id: Int): User
}

@Module
@InstallIn(SingletonComponent::class)
abstract class UserRemoteDataSourceModule {

    @Binds
    abstract fun bindUserRemoteDataSource(
        userRemoteDataSourceImpl: UserRemoteDataSourceImpl
    ): UserRemoteDataSource
}
