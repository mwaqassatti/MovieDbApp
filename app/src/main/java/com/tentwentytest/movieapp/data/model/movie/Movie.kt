package com.tentwentytest.movieapp.data.model.movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @ColumnInfo(defaultValue = "")
    @SerializedName("backdrop_path")
    val backdrop_path: String,
    /*@SerializedName("genre_ids")
    val genre_ids: List<Int>,*/
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("title")
    val title: String
) {
    constructor() : this(
        -1,
        "",
        "",
        "",
        "",
        ""
    )
}