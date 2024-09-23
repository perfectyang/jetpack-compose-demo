package com.perfectyang.personbank.db.PersonBankDb

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class PersonBankEntity(
    var bank_name: String? = "",
    var bank_number: String? = "",
    var userId: String? = "",
    var valid_time: String? = "",
    var back_card_three: String? = "",
    // 1 信用卡， 2 借记卡
    var category: String = "1",
    var bill_date: String? = "",
    var pay_date: String? = "",
    var quota: String? = "",


    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
)
