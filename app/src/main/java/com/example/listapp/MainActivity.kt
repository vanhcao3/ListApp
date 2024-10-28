package com.example.listapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var editTextItem: EditText
    private lateinit var buttonAdd: Button
    private lateinit var adapter: ArrayAdapter<String>
    private val itemList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        editTextItem = findViewById(R.id.editTextItem)
        buttonAdd = findViewById(R.id.buttonAdd)

        adapter = ArrayAdapter(this, R.layout.list_item, R.id.textViewItem, itemList)
        listView.adapter = adapter

        buttonAdd.setOnClickListener {
            val itemText = editTextItem.text.toString()
            if (itemText.isNotBlank()) {
                itemList.add(itemText)
                adapter.notifyDataSetChanged()
                editTextItem.text.clear()
            }
        }
    }
}
