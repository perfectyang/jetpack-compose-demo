package com.perfectyang.personbank.db.PersonBankDb

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonBankDao {

    @Upsert()
    suspend fun upsertPersonBank(personBank: PersonBankEntity)

    @Query("SELECT * FROM PersonBankEntity where userId = :userId and category = :category")
    fun getPersonBank(userId: Long?, category: String): Flow<List<PersonBankEntity>>


    @Query("DELETE FROM PersonBankEntity where id = :id")
    suspend fun deletePersonBank(id: Int)


    @Query("SELECT * FROM PersonBankEntity where userId = :userId AND category = :category AND  bank_name LIKE :bankName")
    fun searchPersonBank(bankName: String, userId: Long?, category: String): Flow<List<PersonBankEntity>>


    @Query("SELECT * FROM PersonBankEntity where id = :id")
    suspend fun getPersonBankDetail(id: Int): PersonBankEntity


}