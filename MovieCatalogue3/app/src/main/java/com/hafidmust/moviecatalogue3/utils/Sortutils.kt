package com.hafidmust.moviecatalogue3.utils

import androidx.sqlite.db.SimpleSQLiteQuery

object Sortutils {
    const val NEWEST = "newest"
    const val OLDEST = "oldest"
    const val TABLE_MOVIE = "movieentities"
    const val TABLE_TV = "tvshowentities"
    fun getSortedQuery(sort : String, table: String) : SimpleSQLiteQuery{
        val simpleQuery = StringBuilder().append("SELECT * FROM $table ")
        if (sort == NEWEST){
            simpleQuery.append("ORDER BY id DESC")
        }else if(sort == OLDEST){
            simpleQuery.append("ORDER BY id ASC")
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }
}