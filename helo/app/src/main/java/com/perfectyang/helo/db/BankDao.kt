package com.perfectyang.helo.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.perfectyang.helo.db.entity.Bank

@Dao
interface BankDao {

    @Query("SELECT * FROM Bank ORDER BY createdAt DESC")
    fun getAllBank() : LiveData<List<Bank>>

    @Insert
    fun addBank(bank : Bank)

    @Query("Delete FROM Bank where id = :id")
    fun deleteBank(id : Int)

   @Query("SELECT * FROM Bank where bankName = :bankName")
   fun search(bankName: String) : LiveData<List<Bank>>
}
