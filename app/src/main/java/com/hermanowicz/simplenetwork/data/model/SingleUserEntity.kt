package com.hermanowicz.simplenetwork.data.model

import com.google.gson.annotations.SerializedName

data class SingleUserEntity(
    @SerializedName("data")
    val data: UserEntity? = null,
    @SerializedName("support")
    val support: SupportEntity? = null
)