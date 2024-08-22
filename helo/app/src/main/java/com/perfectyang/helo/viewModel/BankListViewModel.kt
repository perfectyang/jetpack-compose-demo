package com.perfectyang.helo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.perfectyang.helo.MainActivity
import com.perfectyang.helo.MainApplication
import com.perfectyang.helo.db.entity.Bank
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date


class BankListViewModel: ViewModel() {
    val bankDao = MainApplication.bankDatabase.getBankDao()
    var bankList : LiveData<List<Bank>> = bankDao.getAllBank()

    fun addBank(bank: Bank){
        viewModelScope.launch(Dispatchers.IO) {
            bankDao.addBank(Bank(
                type = bank.type,
                bankName = bank.bankName,
                bankCard = bank.bankCard,
                backNum = bank.backNum,
                validDate = bank.validDate,
                createdAt = Date.from(Instant.now())),
            )
        }
    }
//
    fun deleteBank(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            bankDao.deleteBank(id)
        }
    }

    fun searchBank(bankName : String){
        viewModelScope.launch(Dispatchers.IO) {
            if (bankName.trim().isNotEmpty()) {
            } else {
                bankList = bankDao.getAllBank()
            }
        }
    }

}