package com.hermanowicz.simplenetwork.domain

import com.hermanowicz.simplenetwork.di.repository.UserRepository
import javax.inject.Inject

class RegisterTestUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) : suspend () -> String {
    override suspend fun invoke(): String {
        return userRepository.registerUser()
    }
}