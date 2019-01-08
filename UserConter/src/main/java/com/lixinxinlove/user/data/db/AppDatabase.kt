package com.lixinxinlove.user.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kotlin.user.data.protocol.UserInfo
import com.lixinxinlove.user.data.dao.UserInfoDao

@Database(entities = [UserInfo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userInfoDao(): UserInfoDao

//    companion object {
//        // For Singleton instantiation
//        @Volatile
//        private var instance: AppDatabase? = null
//
//        fun getInstance(context: Context): AppDatabase {
//            return instance ?: synchronized(this) {
//                instance ?: buildDatabase(context).also { instance = it }
//            }
//        }
//
//        private fun buildDatabase(context: Context): AppDatabase {
//            return Room.databaseBuilder(context, AppDatabase::class.java, "mishop").fallbackToDestructiveMigration()
//                .build()
//        }
//    }
}