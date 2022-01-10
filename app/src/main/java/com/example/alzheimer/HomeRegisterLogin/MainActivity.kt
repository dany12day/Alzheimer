package com.example.alzheimer.HomeRegisterLogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.alzheimer.Documents.DocumentAdapter
import com.example.alzheimer.DataConfiguration.DataConfogurationModel
import com.example.alzheimer.Emergency.ContactsAdapter
import com.example.alzheimer.Emergency.EmergencyActivity
import com.example.alzheimer.FamilyInfo.FamilyAdapter
import com.example.alzheimer.Maps.ImportantLocation
import com.example.alzheimer.Maps.ImportantLocationsAdapter
import com.example.alzheimer.Notes.NotesAdapter
import com.example.alzheimer.PersonalInformation.PersonalInfoModel
import com.example.alzheimer.R
import com.example.alzheimer.ReminderMedicine.RemindersAdapter
import com.example.alzheimer.Util.CurrentUser
import com.example.alzheimer.Util.UserInfo
import com.example.alzheimer.Util.UsersList
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var remindersAdapter: RemindersAdapter
    private lateinit var importantLocationsAdapter: ImportantLocationsAdapter
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var contactsAdapter: ContactsAdapter
    private lateinit var documentsAdapter: DocumentAdapter
    private lateinit var familyAdapter: FamilyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        remindersAdapter = RemindersAdapter(
            context = this,
        )

        importantLocationsAdapter = ImportantLocationsAdapter(
            context = this,
        )

        notesAdapter = NotesAdapter(
            context = this,
        )

        contactsAdapter = ContactsAdapter(
            context = this,
        )
        familyAdapter = FamilyAdapter(
            context = this,
        )

        documentsAdapter = DocumentAdapter(
            context = this,
        )

        val usernameError = findViewById<TextView>(R.id.usernameError)
        val passwordError = findViewById<TextView>(R.id.passwordError)

        val usernameInput = findViewById<TextInputEditText>(R.id.usernameInput)
        val passwordInput = findViewById<TextInputEditText>(R.id.passwordInput)


        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            val usernameVal = usernameInput.text.toString()
            val passwordVal = passwordInput.text.toString()

            var ok = true

            val usernameResult = validateUsername(usernameVal)
            if (!usernameResult.first) {
                usernameError.visibility = View.VISIBLE

                ok = false

                when(usernameResult.second) {
                    0 -> { usernameError.text = "Username is too short" }
                    1 -> { usernameError.text = "Username is empty" }
                    2 -> { usernameError.text = "Username is not valid" }
                }
            } else {
                usernameError.visibility = View.GONE
            }

            val passwordResult = validatePassword(passwordVal)
            if (!passwordResult.first) {
                passwordError.visibility = View.VISIBLE

                ok = false

                when(passwordResult.second) {
                    0 -> { passwordError.text = "Password is too short" }
                    1 -> { passwordError.text = "Password is empty" }
                    2 -> { passwordError.text = "Password is not valid" }
                }
            } else {
                passwordError.visibility = View.GONE
            }

            if (ok) {
                CurrentUser.userInfo.personalInfo = PersonalInfoModel("Test", "25.10.1999", "Observatorului, Cluj", "CJ20JBN","0758963148")
                CurrentUser.userInfo.dataConf = DataConfogurationModel("Test", "25.10.1999", "Observatorului, Cluj", "CJ20JBN","0758963148")
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
        val registerButton = findViewById<Button>(R.id.registerButton)
        registerButton.setOnClickListener {
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

    }



    private fun validateUsername(
        username: String,
    ): Pair<Boolean, Int> {

        val numbersIterator =  UsersList.userList.iterator()
        while (numbersIterator.hasNext()) {
            var user : UserInfo = numbersIterator.next()
            if (username == user.username) {
                CurrentUser.userInfo = user
                remindersAdapter.setList(user.userData.remindersList)
                importantLocationsAdapter.setList(user.userData.importantLocationsList)
                notesAdapter.setList(user.userData.notesList)
                contactsAdapter.setList(user.userData.contactsList)
                documentsAdapter.setList(user.userData.documentsList)

                familyAdapter.setList(user.userData.familyList)

                return Pair(true, -1)
            }
        }


        return Pair(false, 2)
    }

    private fun validatePassword(
        password: String,
    ): Pair<Boolean, Int> {

        val numbersIterator =  UsersList.userList.iterator()
        while (numbersIterator.hasNext()) {
            if (password == numbersIterator.next().password)
                return Pair(true, -1)
        }

        return Pair(false, 2)
    }

    fun getNotesAdapter(): NotesAdapter {
        return notesAdapter
    }
}