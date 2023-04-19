package com.example.three_lines

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class NotesApplication: Application() {


    /*
    init {
        instance = this
    }
    companion object{
        private var instance: NotesApplication? = null

        fun getApplicationContext() = instance?.applicationContext
    }
*/
}
