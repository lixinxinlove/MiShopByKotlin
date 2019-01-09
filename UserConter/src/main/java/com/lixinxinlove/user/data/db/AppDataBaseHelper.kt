package com.lixinxinlove.user.data.db

import android.content.Context
import androidx.room.Room

class AppDataBaseHelper constructor(context: Context) {

    val appDataBase = Room.databaseBuilder(context, AppDataBase::class.java, "db_room").build()!!

    companion object {
        @Volatile
        var INSTANCE: AppDataBaseHelper? = null

        fun getInstance(context: Context): AppDataBaseHelper {
            if (INSTANCE == null) {
                synchronized(AppDataBaseHelper::class) {
                    if (INSTANCE == null) {
                        INSTANCE = AppDataBaseHelper(context.applicationContext)
                    }
                }
            }
            return INSTANCE!!
        }
    }
}