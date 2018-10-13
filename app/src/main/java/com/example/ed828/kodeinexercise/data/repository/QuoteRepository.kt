package com.example.ed828.kodeinexercise.data.repository

import androidx.lifecycle.LiveData
import com.example.ed828.kodeinexercise.data.model.Quote

interface QuoteRepository {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}