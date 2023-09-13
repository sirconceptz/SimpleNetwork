package com.hermanowicz.simplenetwork.data.remote.dataSource

import android.util.Log
import com.google.gson.Gson
import com.hermanowicz.simplenetwork.data.mapper.toDomainModel
import com.hermanowicz.simplenetwork.data.model.NewAccountEntity
import com.hermanowicz.simplenetwork.data.model.SingleUserEntity
import com.hermanowicz.simplenetwork.data.model.User
import com.hermanowicz.simplenetwork.data.model.UserListEntity
import com.hermanowicz.simplenetwork.di.remote.dataSource.UserRemoteDataSource
import com.hermanowicz.simplenetwork.utils.ApiDetails.API_FETCH_ALL_USERS_URL
import com.hermanowicz.simplenetwork.utils.ApiDetails.API_FETCH_USER_BY_ID_URL
import com.hermanowicz.simplenetwork.utils.ApiDetails.API_POST_URL
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
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
                call.cancel()
            }
        })
    }

    override suspend fun registerUser() : String = suspendCoroutine { continuation ->
        val sampleData = NewAccountEntity(email = "test@email.com", password = "testPasswd1!")
        val okhttp = OkHttpClient.Builder().build()
        val gson = Gson()
        val body: RequestBody = gson.toJson(sampleData).toRequestBody("application/json; charset=utf-8".toMediaType())
        val request: Request = Request.Builder()
            .url(API_POST_URL)
            .post(body)
            .build()

        okhttp.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val string = response.body!!.string()
                Log.d("Register", string)
                continuation.resume(string)
            }

            override fun onFailure(call: Call, e: IOException) {
                continuation.resumeWithException(e)
                call.cancel()
            }
        })
    }
}