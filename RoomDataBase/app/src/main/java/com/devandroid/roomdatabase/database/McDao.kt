package com.devandroid.roomdatabase.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.devandroid.roomdatabase.model.MC
import com.devandroid.roomdatabase.model.User

@Dao
interface McDao {
    @Insert
    suspend fun insertUser(mc: MC)

    @Update
    suspend fun updateUser(mc: MC)

    @Delete
    suspend fun deleteUser(user: MC)


    @Query("Select *from mancity")
    fun getAllUser(): LiveData<MutableList<MC>>

}