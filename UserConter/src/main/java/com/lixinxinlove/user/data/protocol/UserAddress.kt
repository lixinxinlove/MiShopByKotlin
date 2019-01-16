package com.lixinxinlove.user.data.protocol

data class UserAddress(
    var id: Int,
    var userId: Int,
    var receiverName: String,
    var receiverPhone: String,
    var receiverMobile: String,
    var receiverProvince: String,
    var receiverCity: String,
    var receiverDistrict: String,
    var receiverAddress: String,
    var receiverZip: String
)