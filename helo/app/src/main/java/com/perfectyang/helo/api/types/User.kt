package com.perfectyang.helo.api.types


data class UserInfoEntity(val userId: String, val accessToken: String, val refreshToken: String, val username: String)

data class UserType(val data: UserInfoEntity?): BaseResponse()
