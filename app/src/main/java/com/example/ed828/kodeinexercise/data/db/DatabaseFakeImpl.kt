package com.example.ed828.kodeinexercise.data.db

class DatabaseFakeImpl : Database{
    override val quoteDao: QuoteDao
        get() = QuoteDaoFakeImpl()  // no loose dependency here because fake database always want fake implementation.

}