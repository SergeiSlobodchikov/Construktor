package com.example.construktor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ResultAdapter(var resultList: List<Set>, var context: Context ): RecyclerView.Adapter<ResultAdapter.MyViewHolder>(){
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.result_img)
        val tittle: TextView = view.findViewById(R.id.result_tittle)
        val result: TextView = view.findViewById(R.id.result_final)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.result_in_list, parent, false)
        return ResultAdapter.MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  resultList.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tittle.text = resultList[position].tittle
        holder.result.text = resultList[position].result

        val imageId = context.resources.getIdentifier(
            resultList[position].image, "drawable",
            context.packageName
        )
        holder.image.setImageResource(imageId)
    }

}
