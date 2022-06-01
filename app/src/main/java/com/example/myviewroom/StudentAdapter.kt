package com.example.myviewroom

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.security.AccessController.getContext

//class StudentAdapter(private val studentList: List<RStudent>): RecyclerView.Adapter<ViewHolder>() {
class StudentAdapter(private val studentList: List<Students>): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflate
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // add element to view holder
        val itemVM = studentList[position]
        holder.fname.text = itemVM.firstName
        holder.lname.text = itemVM.lastName
        holder.id.text = itemVM.studentId.toString()

        holder.card.setOnClickListener() {
            //Toast.makeText(holder.card.getContext(), itemVM.studentId.toString(), Toast.LENGTH_SHORT).show()
            Log.d("CARD CLICKED", itemVM.studentId.toString())
        }
    }

    override fun getItemCount(): Int {
        // size of the list/datasource
        return studentList.size
    }
}

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val fname : TextView = view.findViewById(R.id.firstnameTV)
    val lname : TextView = view.findViewById(R.id.lastnameTV)
    val id : TextView = view.findViewById(R.id.idTV)
    val card : LinearLayout = view.findViewById(R.id.studentCard)
}