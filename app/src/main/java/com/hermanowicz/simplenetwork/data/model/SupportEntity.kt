package com.hermanowicz.simplenetwork.data.model

import com.google.gson.annotations.SerializedName

data class SupportEntity(
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("text")
    val text: String? = null
)
