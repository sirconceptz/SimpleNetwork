package com.hermanowicz.simplenetwork.data.model

import com.google.gson.annotations.SerializedName

data class NewAccountEntity(
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("password")
    val password: String? = null
)
