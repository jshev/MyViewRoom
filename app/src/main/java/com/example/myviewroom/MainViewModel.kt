package com.example.myviewroom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(app: Application) : AndroidViewModel(app) {
    private val repo: StudentsRepository
    val allStudents : LiveData<List<Students>>

    init {
        repo = StudentsRepository(app)
        allStudents = repo.getAllStudents()!!
    }

    fun getAllStudents() = viewModelScope.launch {
        repo.getAllStudents()
    }

    fun deleteAllStudents() = viewModelScope.launch {
        repo.deleteAllStudents()
    }

    fun insertStudent(student: Students) = viewModelScope.launch {
        repo.insertStudent(student)
    }

    fun updateStudent(student: Students) = viewModelScope.launch {
        repo.updateStudent(student)
    }

    fun deleteStudent(student: Students) = viewModelScope.launch {
        repo.deleteStudent(student)
    }
}