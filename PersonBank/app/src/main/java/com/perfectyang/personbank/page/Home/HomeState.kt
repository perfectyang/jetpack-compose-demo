package com.perfectyang.personbank.page.Home

import com.perfectyang.personbank.db.PersonBankDb.PersonBankEntity

data class HomeState (
    var searchValue: String = "",
    val category: String = "1",
    var personBankList: List<PersonBankEntity> = emptyList(),
)