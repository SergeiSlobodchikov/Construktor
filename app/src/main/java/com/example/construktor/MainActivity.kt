package com.example.construktor

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        val buttonAddDetal: Button = findViewById(R.id.add_detal)
        val buttonAddSet: Button = findViewById(R.id.add_set)
        val buttonResult: Button = findViewById(R.id.resultButton)
        val buttonReset: Button = findViewById(R.id.button_reset)

        val db = DbHelper(this, null)

        var count = 1
        buttonAddDetal.setOnClickListener {
            if(count == 1) {
            db.deleteAndCreateNewDatabase()
                count++
            }
            val intent = Intent(this, AddDetailActivity::class.java)
            startActivity(intent)
        }



        buttonAddSet.setOnClickListener {

            if(count == 1) {
                db.deleteAndCreateNewDatabase()
                count++
            }
            val intent = Intent(this, AddSetActivity::class.java)
            startActivity(intent)
        }

        buttonResult.setOnClickListener {
            val hasData = db.checkSetsCount()
            if(hasData > 0) {
                val intent = Intent(this, ResultActivity::class.java)
                startActivity(intent)
            }
        }

        buttonReset.setOnClickListener {
            db.deleteAndCreateNewDatabase()
        }
    }
}