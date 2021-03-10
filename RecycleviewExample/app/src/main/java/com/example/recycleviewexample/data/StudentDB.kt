package com.example.recycleviewexample.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StudentEntity::class], version = 1, exportSchema = false)
abstract class StudentDB:RoomDatabase() {
    abstract fun studentDAO():StudentDAO

    companion object{
        private var INSTANCE : StudentDB? = null

        fun getDatabase(context: Context):StudentDB{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    //if null then add a db
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentDB::class.java,
                        "student_database"
                    ).fallbackToDestructiveMigration().build()
                }
                return instance
            }
        }
    }
}