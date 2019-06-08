package com.qbox.android.nestrecyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

class RecyclerTouchListener(val context: Context,
                            val recyclerView: RecyclerView,
                            val clickListener: ClickListener,
                            val gestureDetector: GestureDetector)
    : RecyclerView.OnItemTouchListener {

    interface ClickListener {
        fun onClick(view: View, position: Int)

        fun onLongClick(view: View, position: Int)
    }

    fun onSingleTapUp(event: MotionEvent) : Boolean = true

    fun onLongPress(event: MotionEvent) {
        val child: View? = recyclerView.findChildViewUnder(event.getX(), event.getY())
        if (child != null) {
            clickListener.onLongClick(child, recyclerView.getChildPosition(child))
        }
    }

    override fun onInterceptTouchEvent(recyclerView: RecyclerView, event: MotionEvent): Boolean {
        val child: View? = recyclerView.findChildViewUnder(event.getX(), event.getY())
        if (child != null && gestureDetector.onTouchEvent(event)) {
            clickListener.onClick(child, recyclerView.getChildPosition(child))
        }
        return false
    }

    override fun onTouchEvent(recyclerView: RecyclerView, event: MotionEvent) {
    }

    override fun onRequestDisallowInterceptTouchEvent(p0: Boolean) {
    }

}