package com.ghost.moviedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ghost.moviedb.ui.ListOfMoviesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(
            R.id.fragmentContainerView,
            ListOfMoviesFragment()
        ).commit()
    }

}