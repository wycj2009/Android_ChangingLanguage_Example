package com.example.android_changinglanguage_example

import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainButton1: Button
    private lateinit var activityMainButton2: Button
    private lateinit var activityMainButton3: Button
    private lateinit var activityMainButton4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainButton1 = findViewById(R.id.activity_main_button_1)
        activityMainButton2 = findViewById(R.id.activity_main_button_2)
        activityMainButton3 = findViewById(R.id.activity_main_button_3)
        activityMainButton4 = findViewById(R.id.activity_main_button_4)

        activityMainButton1.setOnClickListener {
            Data.language = "ko"
            recreate()
        }
        activityMainButton2.setOnClickListener {
            Data.language = "en"
            recreate()
        }
        activityMainButton3.setOnClickListener {
            Data.language = "ja"
            recreate()
        }
        activityMainButton4.setOnClickListener {
            Data.language = "ii"
            recreate()
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        if (Data.language == null) {
            super.attachBaseContext(newBase)
        } else {
            val local = Locale(Data.language)
            val config = newBase!!.resources.configuration.apply {
                setLocale(local)
            }
            super.attachBaseContext(newBase.createConfigurationContext(config))
        }
    }

}