package com.perfectyang.personbank.db.PersonBankDb

import kotlinx.coroutines.flow.Flow

interface PersonRepository {
    suspend fun upsertPersonBank(personBank: PersonBankEntity)

    suspend fun deletePersonBank(id: Int)

    fun getPersonBank(userId: Long?, category: String): Flow<List<PersonBankEntity>>

    fun searchPersonBank(bankName: String, userId: Long?, category: String): Flow<List<PersonBankEntity>>

    suspend fun getPersonBankDetail(id: Int): PersonBankEntity

}