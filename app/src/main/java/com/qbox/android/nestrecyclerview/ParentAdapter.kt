package com.qbox.android.nestrecyclerview

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.view.*


class ParentAdapter(var list: List<ParentModel>) : RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        return ParentViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val items = mutableListOf<ChildModel>()
        items.addAll(list.get(position).children)
        items.add(2, ChildModel(R.drawable.ic_launcher_foreground))

        val childLayoutManager = LinearLayoutManager(
            holder.recyclerView.context, LinearLayout.HORIZONTAL, false
        )

        holder.recyclerView.apply {
            layoutManager = childLayoutManager
            adapter = ChildAdapter(list[position])
        }

        holder.recyclerView.scrollToPosition(2)
    }

    class ParentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = view.childRecyclerView


    }
}
