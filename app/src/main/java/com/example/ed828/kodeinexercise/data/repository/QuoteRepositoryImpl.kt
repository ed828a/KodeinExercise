package com.example.ed828.kodeinexercise.data.repository

import androidx.lifecycle.LiveData
import com.example.ed828.kodeinexercise.data.db.QuoteDao
import com.example.ed828.kodeinexercise.data.model.Quote


// Because of using Dependency Injection here, the dependency should be inside the constructor
// and the dependency must be the interface, not the concrete implementation class.
class QuoteRepositoryImpl(private val quoteDao: QuoteDao) : QuoteRepository{

    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    override fun getQuotes(): LiveData<List<Quote>> = quoteDao.getQuotes()
}