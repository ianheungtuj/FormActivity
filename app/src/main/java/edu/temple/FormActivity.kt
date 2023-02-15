package edu.temple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val output = findViewById<TextView>(R.id.textView)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val userName = findViewById<TextView>(R.id.editTextTextPersonName)
        val userEmail = findViewById<TextView>(R.id.editTextTextEmailAddress)
        val userPassword = findViewById<TextView>(R.id.editTextTextPassword)
        val passwordConfirmBox = findViewById<TextView>(R.id.editTextTextPasswordConfirm)
        val saveButton = findViewById<TextView>(R.id.button)

        var currentName: String = ""
        var currentEmail : String = ""
        var currentPassword : String = ""
        var confirmPassword : String = ""
        var passwordMatch : Boolean = false
        var spinnerIndex = 0;


        userName.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                currentName = s.toString()
                if(currentName == ""){
                    userName.error = getString(R.string.enter_name)
                }
            }
        })

        userEmail.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                currentEmail = s.toString()
                if(currentEmail == ""){
                    userEmail.error = getString(R.string.enter_email_address)
                }
            }
        })

        userPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                currentPassword = s.toString()
                if(currentPassword == ""){
                    userPassword.error = getString(R.string.enter_password)
                }
            }
        })


        passwordConfirmBox.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                confirmPassword = s.toString()
                if(confirmPassword != currentPassword){
                    passwordConfirmBox.error = getString(R.string.confirm_password)
                } else {
                    passwordMatch = true
                }
            }
        })

        saveButton.setOnClickListener {

            var toastText : String
            val duration = Toast.LENGTH_LONG

            if (spinnerIndex == 0) {
                toastText = "Select a major"
                val toast = Toast.makeText(this, toastText, duration)
                toast.show()
            }

            var missingInfo : Boolean = false

            if(currentName == ""){
                missingInfo = true
                toastText = "Missing name"
                val toast = Toast.makeText(this, toastText, duration)
                toast.show()
            }

            if(currentEmail == ""){
                missingInfo = true
                toastText = "Missing email"
                val toast = Toast.makeText(this, toastText, duration)
                toast.show()
            }

            if(currentPassword == ""){
                missingInfo = true
                toastText = "Missing password"
                val toast = Toast.makeText(this, toastText, duration)
                toast.show()
            }

            if(confirmPassword == ""){
                missingInfo = true
                toastText = "Please confirm password"
                val toast = Toast.makeText(this, toastText, duration)
                toast.show()
            }

            if(!passwordMatch){
                toastText = "Renter password"
                val toast = Toast.makeText(this, toastText, duration)
                toast.show()
            }

            if(!missingInfo && passwordMatch){
                output.text = "Welcome " + currentName
            }
        }

        val programOptions = resources.getStringArray(R.array.majors)

        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, programOptions)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinnerIndex = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }


    }
    }