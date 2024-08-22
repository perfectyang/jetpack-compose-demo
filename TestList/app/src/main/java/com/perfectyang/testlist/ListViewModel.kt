package com.perfectyang.testlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



object TodoManager {
    private  val todoList = mutableListOf(
        Todo("js", "stot")
    )

    fun getAllTodo (): List<Todo>{
        return todoList
    }


}





class ListViewModel: ViewModel() {

    private var _todoList = MutableLiveData<List<Todo>>()
    val todoList: LiveData<List<Todo>> = _todoList


    fun getAllTodo () {
        _todoList.value = TodoManager.getAllTodo()
    }








}