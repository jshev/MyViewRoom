package com.example.myviewroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


// (...) not necessary if table names are the same
@Entity(tableName = "students")
data class Students(@PrimaryKey(autoGenerate = true) var studentId:Int?,
                    @ColumnInfo(name = "firstname") var firstName:String,
                    @ColumnInfo(name = "lastname") var lastName:String) {

}