package com.devandroid.roomdatabase.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "User")

class User(
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "pass") var pass: String = "",
    @ColumnInfo(name = "check") var check: Boolean
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

}




