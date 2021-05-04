package com.maad.aliensapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openInsertActivity(view: View) {
        startActivity(Intent(this, InsertActivity::class.java))
    }

    fun openListActivity(view: View) {
        startActivity(Intent(this, ListActivity::class.java))
    }

}