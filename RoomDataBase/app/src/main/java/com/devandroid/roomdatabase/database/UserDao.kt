package com.devandroid.roomdatabase.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.devandroid.roomdatabase.model.User

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)


    @Query("Select *from User")
    fun getAllUser(): LiveData<MutableList<User>>

}