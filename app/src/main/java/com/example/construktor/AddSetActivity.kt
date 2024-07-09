package com.example.construktor

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AddSetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_set)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        val setsList: RecyclerView = findViewById(R.id.list_set)
        val sets = arrayListOf<Set>()

        sets.add(Set(1, "set_1","Set_1", 0, "Хватает деталей"))
        sets.add(Set(2, "set_2","Set_2", 0,"Хватает деталей"))
        sets.add(Set(3, "set_3","Set_3", 0,"Хватает деталей"))

        setsList.layoutManager = LinearLayoutManager(this)
        setsList.adapter = SetAdapter(sets, this)
    }
}

