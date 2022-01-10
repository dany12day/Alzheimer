package com.example.alzheimer.DataConfiguration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.alzheimer.R
import com.example.alzheimer.Util.CurrentUser
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class DataConfigurationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_configuration)

        val nameValue = findViewById<TextInputEditText>(R.id.nameValue)
        val birthDateValue = findViewById<TextInputEditText>(R.id.birthDateValue)
        val addressValue = findViewById<TextInputEditText>(R.id.addressValue)
        val licensePlateValue = findViewById<TextInputEditText>(R.id.licensePlateValue)
        val phoneNumberValue = findViewById<TextInputEditText>(R.id.phoneNumberValue)


        nameValue.setText(CurrentUser.userInfo.personalInfo.name, TextView.BufferType.EDITABLE)
        birthDateValue.setText(CurrentUser.userInfo.personalInfo.birthDate, TextView.BufferType.EDITABLE)
        addressValue.setText(CurrentUser.userInfo.personalInfo.address, TextView.BufferType.EDITABLE)
        licensePlateValue.setText(CurrentUser.userInfo.personalInfo.licensePlate, TextView.BufferType.EDITABLE)
        phoneNumberValue.setText(CurrentUser.userInfo.personalInfo.phoneNumber, TextView.BufferType.EDITABLE)


        val saveButton = findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener {
            CurrentUser.userInfo.dataConf.name = nameValue.text.toString()
            CurrentUser.userInfo.dataConf.birthDate = birthDateValue.text.toString()
            CurrentUser.userInfo.dataConf.address = addressValue.text.toString()
            CurrentUser.userInfo.dataConf.phoneNumber = phoneNumberValue.text.toString()

        }
    }
}