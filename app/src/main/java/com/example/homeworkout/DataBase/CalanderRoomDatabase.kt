package com.example.homeworkout.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.homeworkout.DAO.CalanderDao
import com.example.homeworkout.Entity.Calander

 @Database(entities = arrayOf(Calander::class),exportSchema = false,version = 1)
public abstract class CalanderRoomDatabase:RoomDatabase() {
    abstract fun getDao():CalanderDao

     companion object {
         // Singleton prevents multiple instances of database opening at the
         // same time.
         @Volatile
         private var INSTANCE: CalanderRoomDatabase? = null

         fun getDatabase(context: Context): CalanderRoomDatabase {
             // if the INSTANCE is not null, then return it,
             // if it is, then create the database
             return INSTANCE ?: synchronized(this) {
                 val instance = Room.databaseBuilder(
                     context.applicationContext,
                     CalanderRoomDatabase::class.java,
                     "calander_database"
                 ).build()
                 INSTANCE = instance
                 // return instance
                 instance
             }
         }
     }


}