package com.qbox.android.nestrecyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        val recyclerView: RecyclerView = findViewById(R.id.parentRecyclerView)
        val adapter = ParentAdapter(getParentData())

        //vertical RV
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = adapter
    }

    private fun getParentData() : List<ParentModel> {
        val list = mutableListOf<ParentModel>()
        for (i in 0..15) {
            val data = ParentModel("Movie${i+1}", "Action & Adventure", "2008", getChildData())
            list.add(data)
        }
        return list
    }

    private fun getChildData(): List<ChildModel> {
        val list = mutableListOf<ChildModel>()
        val icon = R.drawable.ic_launcher_foreground
        for (i in 0..4) {
            val data = ChildModel(icon)
            list.add(data)
        }
        return list
    }
}
