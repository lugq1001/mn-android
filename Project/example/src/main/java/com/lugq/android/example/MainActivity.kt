package com.lugq.android.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.lugq.android.MNAndroid

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MNAndroid().test()
    }
}
