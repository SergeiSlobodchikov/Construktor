package com.example.construktor

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val resultList: RecyclerView = findViewById(R.id.list_result)
        val results = ArrayList<Set>()

        val dbHelper = DbHelper(this, null)
        results.addAll(dbHelper.getSets())

        resultList.layoutManager = LinearLayoutManager(this)
        resultList.adapter = ResultAdapter(results, this)

    }
}
