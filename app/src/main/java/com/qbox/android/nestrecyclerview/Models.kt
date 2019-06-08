package com.qbox.android.nestrecyclerview

data class ParentModel(
    var title: String,
    var genre: String,
    var year: String,
    val children: List<ChildModel>
)

data class ChildModel(
    var image: Int = -1
)