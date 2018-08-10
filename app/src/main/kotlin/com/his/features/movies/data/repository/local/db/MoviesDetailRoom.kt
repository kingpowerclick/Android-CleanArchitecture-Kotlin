package com.his.features.movies.data.repository.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "movie_details")
data class MoviesDetailRoom(@PrimaryKey(autoGenerate = true)
                            @ColumnInfo(name = "primary_key") var primaryKey: Int = 0,
                            @ColumnInfo(name = "id") var id: Int = 0,
                            @ColumnInfo(name = "title") var title: String? = null,
                            @ColumnInfo(name = "poster") var poster: String? = null,
                            @ColumnInfo(name = "summary") var summary: String? = null,
                            @ColumnInfo(name = "cast") var cast: String? = null,
                            @ColumnInfo(name = "director") var director: String? = null,
                            @ColumnInfo(name = "year") var year: Int? = 0,
                            @ColumnInfo(name = "trailer") var trailer: String? = null) {

	@Ignore constructor() : this(0)
}

