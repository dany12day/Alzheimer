package com.example.alzheimer.HomeRegisterLogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.alzheimer.R
import com.example.alzheimer.Util.UserInfo
import com.example.alzheimer.Util.UsersList
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val reminderMedicineButton = findViewById<Button>(R.id.registerUserButton)
        reminderMedicineButton.setOnClickListener {

            // sava user in database

            val registerUsernameInput = findViewById<TextInputEditText>(R.id.registerUsernameInput)
            val registerPasswordInput = findViewById<TextInputEditText>(R.id.registerPasswordInput)
            val registerRoleInput = findViewById<TextInputEditText>(R.id.registerRoleInput)

            UsersList.userList.add(UserInfo(registerUsernameInput.text.toString(),registerPasswordInput.text.toString(), registerRoleInput.text.toString()))

            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(intent)

        }
    }
}