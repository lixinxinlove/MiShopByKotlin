package com.lixinxinlove.user.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kotlin.user.data.protocol.UserInfo
import com.lixinxinlove.user.data.dao.UserInfoDao

@Database(entities = arrayOf(UserInfo::class), version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userInfoDao(): UserInfoDao
}