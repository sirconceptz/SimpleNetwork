package com.hermanowicz.simplenetwork.domain

import com.hermanowicz.simplenetwork.data.model.User
import com.hermanowicz.simplenetwork.di.repository.UserRepository
import javax.inject.Inject

class FetchUserByIdUseCase @Inject constructor(
    private val userRepository: UserRepository
) : suspend (Int) -> User? {
    override suspend fun invoke(id: Int): User? {
        return userRepository.fetchUserById(id)
    }
}