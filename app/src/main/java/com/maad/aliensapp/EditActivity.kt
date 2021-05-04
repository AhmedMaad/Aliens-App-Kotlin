package com.maad.aliensapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class EditActivity : AppCompatActivity() {

    private var receivedID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        setTitle(R.string.edit_activity)
        receivedID = intent.getIntExtra("id", 0)
        val nameET: EditText = findViewById(R.id.et_name)
        nameET.setText(intent.getStringExtra("name"))
    }

    fun updateAlien(view: View) {
        val nameET: EditText = findViewById(R.id.et_name)
        val writtenName = nameET.text.toString()

        val content = ContentValues()
        content.put("name", writtenName)

        val helper = DBHelper(this)
        val db = helper.writableDatabase

        val whereArgs = arrayOf(receivedID.toString())
        val affectedRows = db.update("Alien", content, "_id = ?", whereArgs)
        if (affectedRows != 0) {
            Toast.makeText(this, R.string.alien_updated, Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    fun deleteAlien(view: View) {

        val helper = DBHelper(this)
        val db = helper.writableDatabase

        val whereArgs = arrayOf(receivedID.toString())
        val deletedRows = db.delete("Alien", "_id = ?", whereArgs)
        if (deletedRows != 0) {
            Toast.makeText(this, R.string.alien_deleted, Toast.LENGTH_SHORT).show()
            finish()
        }

    }

}