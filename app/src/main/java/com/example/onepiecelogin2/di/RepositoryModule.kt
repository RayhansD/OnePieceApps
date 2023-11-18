package com.example.onepiecelogin2.di

import com.example.onepiecelogin2.Repository
import com.example.onepiecelogin2.data.local.LocalRepository
import com.example.onepiecelogin2.data.remote.RemoteRepository
import org.koin.core.scope.get
import org.koin.dsl.module

val repositoryModule = module {
    single { LocalRepository(get()) }
    single { RemoteRepository(get()) }
    single { Repository(get(), get()) }
}