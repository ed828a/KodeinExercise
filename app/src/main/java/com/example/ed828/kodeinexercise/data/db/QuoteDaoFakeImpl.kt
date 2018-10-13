package com.example.ed828.kodeinexercise.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ed828.kodeinexercise.data.model.Quote

class QuoteDaoFakeImpl: QuoteDao {

    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    override fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList // to update the value of mutable live data which will notify its active observers
    }

    override fun getQuotes(): LiveData<List<Quote>> = quotes as LiveData<List<Quote>>
}