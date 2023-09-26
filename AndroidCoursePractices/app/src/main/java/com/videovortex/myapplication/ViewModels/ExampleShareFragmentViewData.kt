package com.videovortex.myapplication.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExampleShareFragmentViewData : ViewModel(){

    //TODO LOGIC OF VIEW DATA LIVE DATA
    private val _taskList = MutableLiveData<List<String>>()

    val taskList: LiveData<List<String>>
        get() = _taskList

    init {
        // Inicializa la lista de tareas con datos iniciales
        _taskList.value = listOf()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("Example", "Example destroyed!")
    }

    // Método para agregar una tarea a la lista
    fun addTask(task: String) {
        val currentList = _taskList.value?.toMutableList() ?: mutableListOf()
        currentList.add(task)
        _taskList.value = currentList
    }

    fun getListToString(): String {
        val lista = _taskList.value ?: emptyList()
        return lista.joinToString(separator = "\n")
    }
}