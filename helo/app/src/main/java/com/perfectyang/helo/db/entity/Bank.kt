package com.perfectyang.helo.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date

@Entity
data class Bank (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    // 1为银行，2为信用卡
    var type: String = "1",
    var bankName: String = "",
    var bankCard: String = "",
    var validDate: String = "",
    var backNum: String = "",
    var createdAt : Date
)