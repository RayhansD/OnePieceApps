package com.example.onepiecelogin2.di

import androidx.room.Room
import com.example.onepiecelogin2.data.local.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.dsl.single

val roomModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "db")
            .build()
    }
}