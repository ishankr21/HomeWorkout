package com.example.homeworkout

import androidx.lifecycle.LiveData
import com.example.homeworkout.DAO.CalanderDao
import com.example.homeworkout.Entity.Calander

class CalanderRepo(private val CalDao:CalanderDao) {

    val allData:LiveData<List<Calander> > = CalDao.getAll()

    fun insert(calander: Calander)
    {
        CalDao.insertData(calander)
    }

    fun delete(calander: Calander)
    {
        CalDao.delete(calander)
    }




}