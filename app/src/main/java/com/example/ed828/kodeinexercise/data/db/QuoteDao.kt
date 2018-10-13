package com.example.ed828.kodeinexercise.data.db

import androidx.lifecycle.LiveData
import com.example.ed828.kodeinexercise.data.model.Quote

interface QuoteDao {
    fun addQuote(quote:Quote)
    fun getQuotes(): LiveData<List<Quote>>
}