package com.perfectyang.personbank.db.UserDb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UserEntity(
    val username: String,
    val password: String,

    @PrimaryKey(autoGenerate = true)
    val userId: Long? = null
)