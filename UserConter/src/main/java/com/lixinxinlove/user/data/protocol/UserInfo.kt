package com.kotlin.user.data.protocol

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
    用户实体类
 */

@Entity(tableName = "user")
data class UserInfo(

    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var name: String,
    var gender: Byte,
    var age: Int,
    var telphone: String
){

    override fun toString(): String {
        return "UserInfo(id=$id, name='$name', gender=$gender, age=$age, telphone='$telphone')"
    }
}



