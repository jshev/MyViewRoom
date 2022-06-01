package com.example.myviewroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    //lateinit var repo:StudentsRepository
    lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        //repo = StudentsRepository(this)
        vm = MainViewModel(application)

        insertButton.setOnClickListener() {
            var first: String = firstnameET.text.toString()
            var last: String = lastnameET.text.toString()

            if (first != "" && last != "") {
                //repo.insertStudent(Students(null, first, last))
                vm.insertStudent(Students(null, first, last))
                firstnameET.text.clear()
                lastnameET.text.clear()
            }
        }

        mainButton.setOnClickListener() {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}