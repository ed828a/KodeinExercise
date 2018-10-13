package com.example.ed828.kodeinexercise

import android.app.Application
import com.example.ed828.kodeinexercise.data.db.Database
import com.example.ed828.kodeinexercise.data.db.DatabaseFakeImpl
import com.example.ed828.kodeinexercise.data.db.QuoteDao
import com.example.ed828.kodeinexercise.data.repository.QuoteRepository
import com.example.ed828.kodeinexercise.data.repository.QuoteRepositoryImpl
import com.example.ed828.kodeinexercise.ui.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


// we are going to do dependency injection stuff inside the application class,
// because this class is accessible from every component of our app whether it's activity or fragment,
// from anywhere even from services

class QuotesApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        // Kodein has Domain Spedified Language
        bind<Database>() with singleton { DatabaseFakeImpl() }
        // above means Database instance is implemented by DatabaseFakeImpl() and the instance is singleton
        // so here is the place to swap the implementation of the dependencies,
        // for example, if we have a production class called DatabaseProdImpl
        // the code can change to bind<Database>() with singleton { DatabaseProdImpl() }

        bind<QuoteDao>() with singleton {
            // we should get the Daos from the database implementation rather than directly get from fake implementation here.
            instance<Database>().quoteDao
        }

        bind<QuoteRepository>() with singleton {
            // Kodein will use instance() function to  pass the QuoteDao instance above to here as the input parameter
            QuoteRepositoryImpl(instance())
        }

        // here we bind the concrete class
//        bind<QuotesViewModelFactory>() with provider {
//            // provider here will create an instance on every call
//            // so provider instantiates new instance each time that you request this QuoteViewModelFactory
//            QuotesViewModelFactory(instance())
//            // Kodein will create an instance automatically according the Class signature.
//        }
        // because it's binding to its own concrete class, above can be short like below
        bind() from provider { QuotesViewModelFactory(instance()) }
    }

}