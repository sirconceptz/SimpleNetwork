package com.hermanowicz.simplenetwork.data.mapper

import com.hermanowicz.simplenetwork.data.model.User
import com.hermanowicz.simplenetwork.data.model.UserEntity

fun UserEntity.toDomainModel() = User(
    id = id,
    email = email,
    firstName = firstName,
    lastName = lastName,
    avatar = avatar
)

fun User.toEntityModel() = UserEntity(
    id = id,
    email = email,
    firstName = firstName,
    lastName = lastName,
    avatar = avatar
)