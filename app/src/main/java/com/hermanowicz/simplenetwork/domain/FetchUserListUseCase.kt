package com.hermanowicz.simplenetwork.domain

import com.hermanowicz.simplenetwork.data.model.User
import com.hermanowicz.simplenetwork.di.repository.UserRepository
import javax.inject.Inject

class FetchUserListUseCase @Inject constructor(
    private val userRepository: UserRepository
) : suspend () -> List<User> {
    override suspend fun invoke(): List<User> {
        return userRepository.fetchUserList()
    }
}