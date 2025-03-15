package com.example.projecthope.recyclerPS

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projecthope.R

class AppAdapter(private val appList: List<AppModels.AppItem>) :
    RecyclerView.Adapter<AppAdapter.AppViewHolder>() {

    class AppViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val appImage: ImageView = view.findViewById(R.id.appImage)
        val appName: TextView = view.findViewById(R.id.appName)
        val appCategory: TextView = view.findViewById(R.id.appCategory)
        val appSize: TextView = view.findViewById(R.id.appSize)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_app, parent, false)
        return AppViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val app = appList[position]
        holder.appName.text = app.name
        holder.appCategory.text = app.category
        holder.appSize.text = app.size
        holder.appImage.setImageResource(app.imageRes)
    }

    override fun getItemCount() = appList.size
}
