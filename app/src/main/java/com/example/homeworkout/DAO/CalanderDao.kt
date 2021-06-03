package com.example.homeworkout.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.homeworkout.Entity.Calander

@Dao
interface CalanderDao {

    @Insert
   fun insertData(calander: Calander)

    @Delete
    fun delete(calander: Calander)

    @Query("select * from Calander order by id asc")
    fun getAll():LiveData<List<Calander> >
}