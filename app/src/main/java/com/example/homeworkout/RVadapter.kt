package com.example.homeworkout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkout.Entity.Calander

class RVadapter(val context: Context):RecyclerView.Adapter<RVadapter.CalanderViewHolder>() {

    var allNotes=ArrayList<Calander>()
    inner class CalanderViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val txtDate:TextView=itemView.findViewById(R.id.txtDate)
        val txtNumber:TextView=itemView.findViewById(R.id.textnum)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalanderViewHolder {
        val viewHolder=CalanderViewHolder(LayoutInflater.from(context).inflate(R.layout.calander_single_item,parent,false))
        return viewHolder

    }

    override fun onBindViewHolder(holder: CalanderViewHolder, position: Int) {
        val calander=allNotes[position]
        holder.txtDate.text=calander.date
        holder.txtNumber.text=calander.id.toString()
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateList(newList: List<Calander>)
    {
        allNotes.clear()
        allNotes.addAll((newList))
        notifyDataSetChanged()
    }
}