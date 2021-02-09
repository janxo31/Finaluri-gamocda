package com.example.jankhoteliandtsuladzefinaluri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LogIn : AppCompatActivity() {

    private lateinit var LogEmailChawera: EditText
    private lateinit var RegChawera: EditText
    private lateinit var GoBackButon: Button
    private lateinit var ConfirmButon: Button



    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        supportActionBar?.hide()

        LogEmailChawera = findViewById(R.id.LogEmailChawera)
        RegChawera = findViewById(R.id.RegChawera)
        GoBackButon = findViewById(R.id.GoBackButon)
        ConfirmButon = findViewById(R.id.ConfirmButon)


        auth = FirebaseAuth.getInstance()

        GoBackButon.setOnClickListener{
            finish()

        }


        ConfirmButon.setOnClickListener {
            val email: String = LogEmailChawera.text.toString()
            val password: String = RegChawera.text.toString()

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) ) {

                Toast.makeText(this, "Enter Email & Password", Toast.LENGTH_SHORT).show()
            }
            else{
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()

                        } else {


                            Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()

                        }

                    }
            }
        }


    }
}