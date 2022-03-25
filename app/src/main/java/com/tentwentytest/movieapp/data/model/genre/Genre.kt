package com.tentwentytest.movieapp.data.model.genre

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "genre")
data class Genre(
        @PrimaryKey
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String
)