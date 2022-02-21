package com.devandroid.roomdatabase.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "mancity")
class MC(
    @PrimaryKey
    var title:String="",
    var value:String="",
    var check:Boolean=false
):Serializable {

}