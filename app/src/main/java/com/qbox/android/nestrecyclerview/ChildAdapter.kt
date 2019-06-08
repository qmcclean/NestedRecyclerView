package com.qbox.android.nestrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.child_view.view.*

class ChildAdapter(private val parent: ParentModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val upcomingStay: Int = 0
    private val menuItems: Int = 1

    override fun getItemCount(): Int = parent.children.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == upcomingStay) {
            return UpcomingStayHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.parent_view, parent, false)
            )
        } else {
            return ChildVieHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.child_view, parent, false)
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 2) {
            return upcomingStay
        } else {
            return menuItems
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UpcomingStayHolder) {
            holder.genre.text = parent.genre
            holder.title.text = parent.title
            holder.year.text = parent.year

        } else if (holder is ChildVieHolder) {
            holder.imageView.setImageResource(parent.children[position].image)
        }
    }

    class ChildVieHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.image
    }

    class UpcomingStayHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val genre: TextView = view.findViewById(R.id.genre)
        val year: TextView = view.findViewById(R.id.year)

    }

}