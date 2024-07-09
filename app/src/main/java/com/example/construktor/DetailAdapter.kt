package com.example.construktor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class
DetailAdapter(var detail: ArrayList<Detail>, var context: Context) : RecyclerView.Adapter<DetailAdapter.MyViewHolder>(){

class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
    val image: ImageView = view.findViewById(R.id.detail_img)
    val title: TextView = view.findViewById(R.id.detail_tittle)
    val count: EditText = view.findViewById(R.id.detail_count)
    val button: Button = view.findViewById(R.id.detail_button)

}

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.detail_in_list, parent, false)
    return MyViewHolder(view)
}

override fun getItemCount(): Int {
    return detail.count()
}

override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    holder.title.text = detail[position].tittle
    holder.count.inputType = detail[position].count

    val imageId = context.resources.getIdentifier(
        detail[position].image, "drawable",
        context.packageName
    )

    holder.image.setImageResource(imageId)

    fun isNumber(text: String): Boolean {
        return text.all { it.isDigit() }
    }


    holder.button.setOnClickListener {
        val currentCount = holder.count.text.toString().trim()
        val tittleDetail =  detail[position].tittle
        if (isNumber(currentCount)) {
            Toast.makeText(context, "Количество деталей $tittleDetail - $currentCount", Toast.LENGTH_SHORT).show()
            val detailDb = Detail(detail[position].id, detail[position].image, detail[position].tittle, currentCount.toInt())
            val db = DbHelper(context, null)
            db.addDetail(detailDb)
            db.printDetailsWithCount()
        }
        else{
            // Показываем ошибку, если введено некорректное значение
            Toast.makeText(context, "Пожалуйста, введите корректное количество", Toast.LENGTH_SHORT).show()
        }
        }
    }
}
