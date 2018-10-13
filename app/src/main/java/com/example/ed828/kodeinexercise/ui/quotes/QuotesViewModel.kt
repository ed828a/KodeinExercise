package com.example.ed828.kodeinexercise.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.ed828.kodeinexercise.data.model.Quote
import com.example.ed828.kodeinexercise.data.repository.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel(){

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

    fun getQuotes() = quoteRepository.getQuotes()
}