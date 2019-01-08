package com.kotlin.user.data.protocol

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
    用户实体类
 */

@Entity(tableName = "user")
data class UserInfo constructor(

    @PrimaryKey(autoGenerate = false)
    var id: Int=0,
    var name: String?=null,
    var gender: Byte?=0,
    var age: Int?=0,
    var telphone: String?=null
){

    // 必须有公共构造方法
    constructor() : this(0)
    override fun toString(): String {
        return "UserInfo(id=$id, name='$name', gender=$gender, age=$age, telphone='$telphone')"
    }
}



