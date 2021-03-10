package com.example.recycleviewexample.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO {
    //suspend is allowed run in bg
    @Insert
    suspend fun addStudent(s: StudentEntity)

    @Query("Select * from StudentTable")
    suspend fun getAll():Array<StudentEntity>

}