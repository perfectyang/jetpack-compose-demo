package com.perfectyang.personbank.di

import android.app.Application
import androidx.room.Room
import com.perfectyang.personbank.db.PersonBankDb.PersonDataBase
import com.perfectyang.personbank.db.UserDb.UserRepository
import com.perfectyang.personbank.db.UserDb.UserRepositoryImpl
import com.perfectyang.personbank.db.PersonBankDb.PersonRepository
import com.perfectyang.personbank.db.PersonBankDb.PersonRepositoryImpl
import com.perfectyang.personbank.utils.DataStoreRepository.Datastore.historyDataStore
import com.perfectyang.personbank.utils.DataStoreRepository.Datastore.userDataStore
import com.perfectyang.personbank.utils.DataStoreRepository.HistoryDataStoreRepository
import com.perfectyang.personbank.utils.DataStoreRepository.HistoryDataStoreRepositoryImpl
import com.perfectyang.personbank.utils.DataStoreRepository.UserDataStoreRepository
import com.perfectyang.personbank.utils.DataStoreRepository.UserDataStoreRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun  providePersonDataBase(app: Application): PersonDataBase {
        return Room.databaseBuilder(
            app,
            PersonDataBase::class.java,
            "person_bank.db"
        ).build()
    }



    @Provides
    @Singleton
    fun providePersonRepository(db: PersonDataBase): PersonRepository {
        return PersonRepositoryImpl(db.personBankDao)
    }


    @Provides
    @Singleton
    fun provideUserRepository(db: PersonDataBase): UserRepository {
        return UserRepositoryImpl(db.userDao)
    }






    @Provides
    @Singleton
    fun  provideHistoryDataStoreManager(app: Application): HistoryDataStoreRepository {
        return HistoryDataStoreRepositoryImpl(app.historyDataStore)
    }

    @Provides
    @Singleton
    fun  provideUserDataStoreManager(app: Application): UserDataStoreRepository {
        return UserDataStoreRepositoryImpl(app.userDataStore)
    }



}