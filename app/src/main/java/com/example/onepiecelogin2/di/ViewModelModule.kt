package com.example.onepiecelogin2.di

import com.example.onepiecelogin2.ui.home.HomeViewModel
import com.example.onepiecelogin2.ui.login.LoginViewModel
import com.example.onepiecelogin2.ui.register.RegisterViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { LoginViewModel(get()) }
    single { RegisterViewModel(get()) }
    single { HomeViewModel(get()) }
}