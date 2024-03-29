package com.example.alzheimer.Util

import com.example.alzheimer.DataConfiguration.DataConfogurationModel
import com.example.alzheimer.PersonalInformation.PersonalInfoModel


data class UserInfo(var username: String? = null,
                    var password: String? = null,
                    var role: String? = null,
                    var userData: UserData = UserData(
                        mutableListOf(),
                        mutableListOf(),
                        mutableListOf(),
                        mutableListOf(),
                        mutableListOf(),
                    ),
                    var personalInfo: PersonalInfoModel = PersonalInfoModel(),
                    var dataConf: DataConfogurationModel = DataConfogurationModel()
){

}
