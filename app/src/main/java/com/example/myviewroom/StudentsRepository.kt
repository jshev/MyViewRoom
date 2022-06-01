package com.example.myviewroom

import android.content.Context
import androidx.lifecycle.LiveData

class StudentsRepository(context: Context) {
    var db:StudentsDao? = AppDatabase.getInstance(context)?.studentsDao()

    fun getAllStudents(): LiveData<List<Students>>? {
        return db?.selectStudents()
    }

    fun deleteAllStudents() {
        db?.deleteStudents()
    }

    fun insertStudent(student: Students) {
        db?.insertStudent(student)
    }

    fun updateStudent(student: Students) {
        db?.updateStudent(student)
    }

    fun deleteStudent(student: Students) {
        db?.deleteStudent(student)
    }
}