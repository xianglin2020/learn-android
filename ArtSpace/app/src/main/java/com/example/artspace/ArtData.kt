package com.example.artspace

data class ArtData(
    val image: Int,
    val title: String,
    val author: String,
    val year: Int
)

val arts: List<ArtData> = listOf(
    ArtData(R.drawable.image1, "作品一作品一", "作者一", 2018),
    ArtData(R.drawable.image2, "作品二", "作者二", 2019),
    ArtData(R.drawable.image3, "作品三作品三作品三作品三作品三", "作者三", 2020),
)