package com.maad.aliensapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setTitle(R.string.list_activity)
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun loadData() {
        val helper = DBHelper(this)
        val db = helper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM Alien", null)

        val names = ArrayList<String>()
        val ids = ArrayList<Int>()

        while (cursor.moveToNext()) {
            ids.add(cursor.getInt(0))
            names.add(cursor.getString(1))
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)
        val list: ListView = findViewById(R.id.lv)
        list.adapter = adapter
        list.setOnItemClickListener { parent, view, position, id ->
            val i = Intent(this, EditActivity::class.java)
            i.putExtra("name", names.get(position))
            i.putExtra("id", ids.get(position))
            startActivity(i)
        }
    }

}