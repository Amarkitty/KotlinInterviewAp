package com.example.kotlininterviewapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerviewAdapter(val labelDataModel: ArrayList<LabelDataModel>, var context: Context) :
    RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.ic_item_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return labelDataModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(labelDataModel[position], context)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(labelDataModel: LabelDataModel, context: Context) {
            val textViewName = itemView.findViewById(R.id.textView) as TextView
            val imageView = itemView.findViewById(R.id.imageView) as ImageView
            textViewName.text = labelDataModel.name
            Glide.with(context)
                .load(labelDataModel.imageUrl)
                .into(imageView)
        }
    }

}