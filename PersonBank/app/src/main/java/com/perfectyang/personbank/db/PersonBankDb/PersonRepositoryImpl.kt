package com.perfectyang.personbank.db.PersonBankDb

import kotlinx.coroutines.flow.Flow

class PersonRepositoryImpl (
    private val dao: PersonBankDao
): PersonRepository {
    override suspend fun upsertPersonBank(personBank: PersonBankEntity) {
        dao.upsertPersonBank(personBank)
    }

    override fun getPersonBank(userId: Long?, category: String): Flow<List<PersonBankEntity>>{
        return dao.getPersonBank(userId, category)
    }

    override fun searchPersonBank(bankName: String, userId: Long?, category: String): Flow<List<PersonBankEntity>> {
        return dao.searchPersonBank("%$bankName%", userId, category)
    }

    override suspend fun deletePersonBank(id: Int) {
        dao.deletePersonBank(id)
    }
}