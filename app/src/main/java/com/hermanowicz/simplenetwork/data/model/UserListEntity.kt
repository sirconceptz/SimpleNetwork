package com.hermanowicz.simplenetwork.data.model

import com.google.gson.annotations.SerializedName

data class UserListEntity(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("per_page")
    val perPage: Int? = null,
    @SerializedName("total")
    val total: Int? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("data")
    val data: List<UserEntity>? = null
)