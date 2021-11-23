package com.ghost.moviedb.di

import android.app.Application

class Application : Application() {

    lateinit var appComponent: ApplicationComponent


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.create()
    }
}