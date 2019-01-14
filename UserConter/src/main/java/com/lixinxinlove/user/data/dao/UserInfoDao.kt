package com.lixinxinlove.user.data.dao

import androidx.room.*
import com.kotlin.user.data.protocol.UserInfo
import io.reactivex.Single

@Dao
interface UserInfoDao {

    @Query("SELECT * FROM user")
    fun getUsers(): Single<List<UserInfo>>

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUser(id: Int): Single<UserInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(userInfoList: List<UserInfo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userInfo: UserInfo)

    @Delete
    fun deleteUser(userInfo: UserInfo):Single<Int>

    @Delete
    fun deleteAllUser(users: List<UserInfo>):Single<Int>

}