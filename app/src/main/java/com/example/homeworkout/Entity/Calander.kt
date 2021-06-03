package com.example.homeworkout.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Calander")
data class Calander(

    @ColumnInfo(name = "Date") var date:String

)
{
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name ="id") var id=0
}
