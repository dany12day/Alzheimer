package com.example.alzheimer.PersonalInformation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.example.alzheimer.FamilyInfo.FamilyInfoActivity
import com.example.alzheimer.Notes.NotesActivity
import com.example.alzheimer.R
import com.example.alzheimer.Util.CurrentUser
import com.example.alzheimer.Util.UserInfo

class Personallnformation : AppCompatActivity() {

    private lateinit var nameValue: TextView
    private lateinit var birthDateValue: TextView
    private lateinit var addressValue: TextView
    private lateinit var licensePlateValue: TextView
    private lateinit var phoneNumberValue: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personallnformation)

        nameValue = findViewById(R.id.nameValue)
        birthDateValue = findViewById(R.id.birthDateValue)
        addressValue = findViewById(R.id.addressValue)
        licensePlateValue = findViewById(R.id.licensePlateValue)
        phoneNumberValue = findViewById(R.id.phoneNumberValue)


        nameValue.text = CurrentUser.userInfo.personalInfo.name
        birthDateValue.text = CurrentUser.userInfo.personalInfo.birthDate
        addressValue.text = CurrentUser.userInfo.personalInfo.address
        licensePlateValue.text = CurrentUser.userInfo.personalInfo.licensePlate
        phoneNumberValue.text = CurrentUser.userInfo.personalInfo.phoneNumber


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.family_info,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.family_info -> {
                val intent = Intent(this, FamilyInfoActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}