package com.example.alzheimer.Util

import com.example.alzheimer.Maps.ImportantLocation
import com.example.alzheimer.ReminderMedicine.CustomDate
import com.example.alzheimer.ReminderMedicine.DayOfTheWeek
import com.example.alzheimer.ReminderMedicine.Reminder

object UsersList {
    val userList: MutableList<UserInfo> = mutableListOf(
        UserInfo("test", "test1", "patient",
            UserData(
                mutableListOf(
                    ImportantLocation("Home", "Address1"),
                    ImportantLocation("Doctor", "Address2"),
                    ImportantLocation("Store", "Address3"),
                    ImportantLocation("Friends house", "Address4")
                ),
                mutableListOf(
                    Reminder("Medicine1", "Medicine for memory", CustomDate(DayOfTheWeek(mutableListOf(1,2,3,4,5,6,7)), 8, 0, 0)),
                    Reminder("Medicine2", "Vitamins", CustomDate(DayOfTheWeek(mutableListOf(1,3,6)), 12, 0, 0)),
                    Reminder("Medicine3", "Sleeping pill", CustomDate(DayOfTheWeek(mutableListOf(1,2,3,4,5,6,7)), 21, 30, 0)),
                    Reminder("Medicine4", "Antibiotics", CustomDate(DayOfTheWeek(mutableListOf(1,3,5,7)), 15, 32, 50))
                )
            )
        ),
        UserInfo("doctor", "doctor1", "doctor", UserData(mutableListOf(),mutableListOf())),
        UserInfo("patient", "patient1", "patient", UserData(mutableListOf(),mutableListOf()))
    )

}