package com.perfectyang.helo.api

import com.google.gson.annotations.SerializedName
import com.perfectyang.helo.api.types.UserType
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


data class UserInfo (
    @SerializedName("username") val username: String?,
    @SerializedName("password") val password: String?,
    @SerializedName("tenantId") val tenantId: String?,
)

interface User {
    @Headers(value = [
        "Content-Type: application/json",
        "tenant-id: 125"
    ])
    @POST("admin-api/system/auth/login")
    suspend fun signIn(@Body userData: UserInfo): UserType

    companion object {
        fun instance(): User {
            return Network.createService(User::class.java)
        }
    }
}