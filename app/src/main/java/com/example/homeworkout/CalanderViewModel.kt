package com.example.homeworkout

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.homeworkout.DataBase.CalanderRoomDatabase
import com.example.homeworkout.Entity.Calander
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CalanderViewModel(application: Application):AndroidViewModel(application) {

    var allCalander:LiveData<List<Calander> >
    val repo:CalanderRepo

    init {
        val db=CalanderRoomDatabase.getDatabase(application)
        val dao=db.getDao()
         repo=CalanderRepo(dao)
        allCalander=repo.allData
    }
    fun insertCal(calander: Calander)=viewModelScope.launch (Dispatchers.IO)
    {
        repo.insert(calander)
    }

}