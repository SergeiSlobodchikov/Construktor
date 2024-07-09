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


class SetAdapter(var set: List<Set>, var context: Context) : RecyclerView.Adapter<SetAdapter.MyViewHolder>(){

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.set_img)
        val title: TextView = view.findViewById(R.id.set_tittle)
        val count: EditText = view.findViewById(R.id.set_count)
        val button: Button = view.findViewById(R.id.set_button)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.set_in_list, parent, false)
        return SetAdapter.MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return set.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = set[position].tittle
        holder.count.inputType = set[position].count

        val imageId = context.resources.getIdentifier(
            set[position].image, "drawable",
            context.packageName
        )
        holder.image.setImageResource(imageId)

        fun isNumber(text: String): Boolean {
            return text.all { it.isDigit() }
        }


        holder.button.setOnClickListener {

            val currentCount = holder.count.text.toString().trim()
            val tittleSet =  set[position].tittle
            if (isNumber(currentCount)) {
                Toast.makeText(context, "Количество набора $tittleSet - $currentCount", Toast.LENGTH_SHORT).show()
                val setDb = Set(set[position].id, set[position].image, set[position].tittle, currentCount.toInt(), set[position].result)
                val db = DbHelper(context, null)
                db.addSet(setDb)
            }
            else{
                // Показываем ошибку, если введено некорректное значение
                Toast.makeText(context, "Пожалуйста, введите корректное количество", Toast.LENGTH_SHORT).show()
            }

        }

        holder.count.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                holder.count.setHint("") // Скрываем подсказку при фокусе
            } else {
                holder.count.setHint("Введите количество") // Возвращаем подсказку при потере фокуса
            }

        }
    }
}