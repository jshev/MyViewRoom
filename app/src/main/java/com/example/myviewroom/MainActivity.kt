package com.example.myviewroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    //lateinit var repo:StudentsRepository
    lateinit var vm:MainViewModel
    var studentList = ArrayList<Students>()
    lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = MainViewModel(application)
        //repo = StudentsRepository(this)
        //var stu = Students(0, "Julie", "Shevchenko")
        //repo.insertStudent(stu)
        //repo.deleteStudent(stu)

        // init the data source
        //var studentList = ArrayList<RStudent>()

        // populate the datasource
        //for (i in 0..10) {
            //studentList.add(RStudent("Jane", "Doe"))
            //repo.insertStudent(Students(null, "Bob " + i, "Robert " + i))
        //}

        //repo.deleteAllStudents()

        //var studentList = repo.getAllStudents()

        vm.allStudents.observe(this, {
            studentList -> getStudents(studentList)
        })

        // get reference to view to populate
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // create adapter with data source and assign adapter
        adapter = StudentAdapter(studentList)
        recyclerView.adapter = adapter

        floatingButton.setOnClickListener() {
            var intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }

    fun getStudents(studentList: List<Students>) {
        this.studentList.clear()
        this.studentList.addAll(studentList)
        adapter.notifyDataSetChanged()
    }
}