package com.example.onepiecelogin2

import android.app.Application
import com.example.onepiecelogin2.di.networkModule
import com.example.onepiecelogin2.di.repositoryModule
import com.example.onepiecelogin2.di.roomModule
import com.example.onepiecelogin2.di.viewModelModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level


class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@App)
            modules(listOf(
                networkModule,
                repositoryModule,
                roomModule,
                viewModelModule
            ))
            }
    }
}