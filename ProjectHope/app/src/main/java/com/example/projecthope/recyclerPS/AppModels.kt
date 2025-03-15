package com.example.projecthope.recyclerPS

class AppModels {
    data class AppItem(
        val name: String,
        val category: String,
        val rating: Float,
        val size: String,
        val imageRes: Int
    )

    data class CategoryItem(
        val title: String,
        val apps: List<AppItem>
    )
}