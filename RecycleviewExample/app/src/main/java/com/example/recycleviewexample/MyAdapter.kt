package com.example.recycleviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//declare the adapter in <>
class MyAdapter(private val studentList:List<Student>):RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    //ctrl + i to get/select these override fun
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = studentList[position]

        holder.imgView.setImageResource(currentItem.ImageResource)
        holder.tvName.setText(currentItem.name)
        holder.tvProgramme.setText(currentItem.programme)

    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imgView : ImageView = itemView.findViewById(R.id.ivFace)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvProgramme:TextView = itemView.findViewById(R.id.tvProgramme)


    }
}