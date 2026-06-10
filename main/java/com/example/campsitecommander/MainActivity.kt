package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object {
        val itemArray = ArrayList<String>()
        val categoryArray = ArrayList<String>()
        val quantityArray = ArrayList<String>()
        val commentArray = ArrayList<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtItem = findViewById<EditText>(R.id.edtItem)
        val edtCategory = findViewById<EditText>(R.id.edtCategory)
        val edtQuantity = findViewById<EditText>(R.id.edtQuantity)
        val edtComment = findViewById<EditText>(R.id.edtComment)

        val btnGear = findViewById<Button>(R.id.btnGear)
        val btnSecond = findViewById<Button>(R.id.btnSecond)

        btnGear.setOnClickListener {

            val item = edtItem.text.toString()
            val category = edtCategory.text.toString()
            val quantity = edtQuantity.text.toString()
            val comment = edtComment.text.toString()

            if (item.isEmpty() ||
                category.isEmpty() ||
                quantity.isEmpty() ||
                comment.isEmpty()
            ) {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            } else {
                itemArray.add(item)
                categoryArray.add(category)
                quantityArray.add(quantity)
                commentArray.add(comment)

                Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show()

                edtItem.text.clear()
                edtCategory.text.clear()
                edtQuantity.text.clear()
                edtComment.text.clear()
            }
        }

        // Navigate to DetailedActivity
        btnSecond.setOnClickListener {
            startActivity(Intent(this, DetailedActivity::class.java))
        }
    }
}