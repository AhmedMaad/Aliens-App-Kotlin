package com.maad.aliensapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class InsertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
    }

    fun insertAlien(view: View) {

        val nameET: EditText = findViewById(R.id.et_name)
        val writtenName = nameET.text.toString()

        //Create a new map of values, where column names are the keys
        val content = ContentValues()
        content.put("name", writtenName)

        val helper = DBHelper(this)
        val db = helper.writableDatabase
        val id = db.insert("Alien", null, content)
        if (id != -1L)
            Toast.makeText(this, R.string.alien_inserted, Toast.LENGTH_SHORT).show()
    }


}