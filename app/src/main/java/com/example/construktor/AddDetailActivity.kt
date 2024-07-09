package com.example.construktor

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AddDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_detail)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        val detailsList: RecyclerView = findViewById(R.id.list_detal)
        val details = arrayListOf<Detail>()

        details.add(Detail(1, "brick_1_x_1","Brick_1_x_1", 0))
        details.add(Detail(2, "brick_1_x_2","Brick_1_x_2", 0))
        details.add(Detail(3, "brick_1_x_4","Brick_1_x_4", 0))
        details.add(Detail(4, "plate_1_x_1","Plate_1_x_1", 0))

        detailsList.layoutManager = LinearLayoutManager(this)
        detailsList.adapter = DetailAdapter(details, this)
    }
}