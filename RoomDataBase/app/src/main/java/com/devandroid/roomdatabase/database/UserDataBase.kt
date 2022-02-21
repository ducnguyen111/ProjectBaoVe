package com.devandroid.roomdatabase.database

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.devandroid.roomdatabase.model.MC
import com.devandroid.roomdatabase.model.User

@Database(entities = [User::class,MC::class], version = 2)
abstract class UserDataBase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
    abstract fun getMcDao(): McDao
    companion object {
        @Volatile
        private var instance: UserDataBase? = null
        fun getInStance(context: Context): UserDataBase {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(context, UserDataBase::class.java, "UserDataBase").build()
            }
            return instance!!
        }
    }

}





















































































































































































































