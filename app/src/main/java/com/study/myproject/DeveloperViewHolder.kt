package com.study.myproject

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DeveloperViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    private val developerNameTextView: TextView =
        itemView.findViewById(R.id.developer_name_text_view)

    fun binc(naME:String){
        developerNameTextView.text = naME



    }



}