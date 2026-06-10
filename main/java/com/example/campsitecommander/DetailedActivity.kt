package com.example.campsitecommander

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed)

        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)

        val btnDisplay = findViewById<Button>(R.id.btnDisplay)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnQuantity = findViewById<Button>(R.id.btnQuantity)

        btnDisplay.setOnClickListener {

            var output = ""

            for (i in MainActivity.itemArray.indices) {
                output += MainActivity.itemArray[i] + "\n" +
                        MainActivity.categoryArray[i] + "\n" +
                        MainActivity.quantityArray[i] + "\n" +
                        MainActivity.commentArray[i] + "\n\n"
            }

            txtDisplay.text = output
        }

        btnQuantity.setOnClickListener {
            var output = ""

            for (i in MainActivity.quantityArray.indices) {
                if (MainActivity.quantityArray[i].toInt() >= 3) {
                    output += MainActivity.itemArray[i] + "\n" +
                            MainActivity.categoryArray[i] + "\n" +
                            MainActivity.quantityArray[i] + "\n" +

                            MainActivity.commentArray[i] + "\n\n"
                }
            }

            txtDisplay.text = output
        }

        btnBack.setOnClickListener {
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}