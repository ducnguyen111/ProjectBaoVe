package com.devandroid.roomdatabase.repository

import android.app.Application
import androidx.lifecycle.*
import com.devandroid.roomdatabase.database.McDao
import com.devandroid.roomdatabase.database.UserDao
import com.devandroid.roomdatabase.database.UserDataBase
import com.devandroid.roomdatabase.model.MC
import com.devandroid.roomdatabase.model.User

class Repository(application: Application) {
    private val dao: McDao


    init {
        val database: UserDataBase = UserDataBase.getInStance(application)
        dao = database.getMcDao()
    }

    suspend fun insert(user: MC) = dao.insertUser(user)
    suspend fun update(user: MC) = dao.updateUser(user)
    suspend fun delete(user: MC) = dao.deleteUser(user)

    fun getAllUser():LiveData<MutableList<MC>> = dao.getAllUser()

}

