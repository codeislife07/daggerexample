package com.example.daggerexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daggerexample.R
import com.example.daggerexample.RecycleData

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var listData: List<RecycleData>? = null

    fun setlistData(listData: List<RecycleData>?) {
        this.listData = listData
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if(listData ==null)return 0
        return listData?.size!!
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val thumbImage = view.findViewById<ImageView>(R.id.thumbImage)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvDesc = view.findViewById<TextView>(R.id.tvDesc)

        fun bind(data: RecycleData) {
            tvName.text = data.name
            tvDesc.text = data.description

            Glide.with(thumbImage)
                .load(data.owner?.avatar_url)
                .into(thumbImage)
        }
    }
}