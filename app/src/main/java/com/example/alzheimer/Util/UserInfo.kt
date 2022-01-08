package com.example.alzheimer.Util

import com.example.alzheimer.Maps.ImportantLocation

data class UserInfo(var username: String? = null,
                    var password: String? = null,
                    var role: String? = null,
                    var userData: UserData = UserData(
                        mutableListOf(),
                        mutableListOf()
                    )){

}
