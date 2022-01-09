package com.example.alzheimer.Util

import com.example.alzheimer.Emergency.Contact
import com.example.alzheimer.Maps.ImportantLocation
import com.example.alzheimer.Notes.NoteModel
import com.example.alzheimer.ReminderMedicine.CustomDate
import com.example.alzheimer.ReminderMedicine.DayOfTheWeek
import com.example.alzheimer.ReminderMedicine.Reminder
import java.time.LocalDateTime

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
                ),
                mutableListOf(
                    Contact("Doctor", "112302342"),
                    Contact("Ana", "102234342"),
                    Contact("Ioan", "101232342"),
                ),
                mutableListOf(
                    NoteModel( "Cumparaturi", "Prima oara cand ajung la un magazin trebuie sa cumpar paine, legume", LocalDateTime.now().minusDays(5)),
                    NoteModel( "Test Note", "Acesta este un test pentru notite, contine un titlu si un text", LocalDateTime.now().minusDays(2))
                ),
                mutableListOf()
            )
        ),
        UserInfo("doctor", "doctor1", "doctor", UserData(mutableListOf(),mutableListOf())),
        UserInfo("patient", "patient1", "patient", UserData(mutableListOf(),mutableListOf()))
    )

}