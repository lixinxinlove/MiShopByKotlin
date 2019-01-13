package com.lixinxinlove.user.data.db

import android.content.Context
import androidx.room.Room

class UserDataBaseHelper constructor(context: Context) {

    val appDataBase = Room.databaseBuilder(context, AppDataBase::class.java, "db_room").build()!!

    companion object {
        @Volatile
        var INSTANCE: UserDataBaseHelper? = null

        fun getInstance(context: Context): UserDataBaseHelper {
            if (INSTANCE == null) {
                synchronized(UserDataBaseHelper::class) {
                    if (INSTANCE == null) {
                        INSTANCE = UserDataBaseHelper(context.applicationContext)
                    }
                }
            }
            return INSTANCE!!
        }
    }
}