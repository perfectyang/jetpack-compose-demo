package com.perfectyang.flowdemo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch

class CountDownViewModel: ViewModel() {

    val timer = flow<Int> {
        val targetTimer = 5
        var currentTimer = targetTimer
        emit(targetTimer)
        while (currentTimer > 0) {
            delay(1000L)
            currentTimer--
            emit(currentTimer)
        }
    }

//    val a  = MutableStateFlow(0)
//    var aF = a.asStateFlow()

    val fow1 = (1..10).asFlow().onEach { delay(1000L) }
    val fow2 = (10..20).asFlow().onEach { delay(200L) }
    val fow3 = (20..30).asFlow().onEach { delay(100L) }


    var string by mutableStateOf("")
        private set



    init {
        collect()

        fow1.combine(fow2) { n1, n2 ->
           if (n1 > n2)  n1 else n2
        }.combine(fow3) { n, n3 ->
            n3
        }.launchIn(viewModelScope)





//        fow1.zip(fow2) { n1, n2 ->
//            string += "($n1 $n2)\n"
//        }.launchIn(viewModelScope)


    }

    private fun collect () {

//        viewModelScope.launch {
//            timer.collect{ time ->
//                println("the current time is $time")
//            }
//        }
//        viewModelScope.launch {
//            timer.collectLatest{ time ->
//                delay(1500L)
//                println("the current time2 is $time")
//            }
//        }


//        viewModelScope.launch {
//            val result = timer
//                .filter {
//                   it % 2  == 0
//                }
//                .map {
//                    it * it
//                }
//                .onEach {
//                    println("the current-each time is $it")
//                }
////                .collect{ time ->
////                    println("the current time is $time")
////                }
//                .count{
//                    it % 2 == 0
//                }
//            println("result is $result")
//        }



        val f = (1..5).asFlow()

        viewModelScope.launch {
            f.onEach {
                println("start get number $it")
            }
                .collect {
                    println("got number $it")
                    delay(1000L)
                    println("done number $it")
                }
        }



//        viewModelScope.launch {
////            val result = timer.reduce { accumulator, value ->
////               accumulator + value
////            }
//            // reduce 有初始值
//            val result = timer.fold(100) { accumulator, value ->
//                accumulator + value
//            }
//            println("result is $result")
//        }
//
    }







}