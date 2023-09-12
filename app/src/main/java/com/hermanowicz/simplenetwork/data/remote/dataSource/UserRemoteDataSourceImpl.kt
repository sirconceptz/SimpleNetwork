package com.hermanowicz.simplenetwork.data.remote.dataSource

import com.google.gson.Gson
import com.hermanowicz.simplenetwork.data.mapper.toDomainModel
import com.hermanowicz.simplenetwork.data.model.SingleUserEntity
import com.hermanowicz.simplenetwork.data.model.User
import com.hermanowicz.simplenetwork.data.model.UserListEntity
import com.hermanowicz.simplenetwork.di.remote.dataSource.UserRemoteDataSource
import com.hermanowicz.simplenetwork.utils.ApiDetails.API_FETCH_ALL_USERS_URL
import com.hermanowicz.simplenetwork.utils.ApiDetails.API_FETCH_USER_BY_ID_URL
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class UserRemoteDataSourceImpl @Inject constructor() : UserRemoteDataSource {
    override suspend fun fetchUserList(): List<User> = suspendCoroutine { continuation ->
        val okhttp = OkHttpClient.Builder().build()
        val request = Request.Builder().get().url(API_FETCH_ALL_USERS_URL).build()
        okhttp.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body!!.string()
                val userEntityList = Gson().fromJson(body, UserListEntity::class.java)
                val userList = userEntityList.data?.map { it.toDomainModel() } ?: emptyList()
                continuation.resume(userList)
            }

            override fun onFailure(call: Call, e: IOException) {
                continuation.resumeWithException(e)
            }
        })
    }

    override suspend fun fetchUserById(id: Int): User = suspendCoroutine { continuation ->
        val okhttp = OkHttpClient.Builder().build()
        val request = Request.Builder().get().url(API_FETCH_USER_BY_ID_URL + id.toString()).build()
        okhttp.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body!!.string()
                val singleUserEntity = Gson().fromJson(body, SingleUserEntity::class.java)
                val user = singleUserEntity.data!!.toDomainModel()
                continuation.resume(user)
            }

            override fun onFailure(call: Call, e: IOException) {
                continuation.resumeWithException(e)
            }
        })
    }
}