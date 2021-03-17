package com.example.firebasedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnInsert: Button = findViewById(R.id.btnInsert)
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Student")

        btnInsert.setOnClickListener(){
            // Write a message to the database
            val database: FirebaseDatabase = FirebaseDatabase.getInstance()
            val myRef: DatabaseReference = database.getReference("Student")

             myRef.child("WA0003").child("Name").setValue("Mandy")
             myRef.child("WA0003").child("Programme").setValue("RSF")

        }

        var getData = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var sb = StringBuilder();

                for(c in snapshot.children){
                    var name = c.child("Name").getValue()
                    sb.append("${name}\n")
                }

                val txtStudent: TextView = findViewById(R.id.txtStudent)
                txtStudent.setText(sb)
            }

            override fun onCancelled(error: DatabaseError) {

            }

        }

        val btnGet: Button = findViewById(R.id.btnGet)

        btnGet.setOnClickListener(){
            myRef.addValueEventListener(getData)
            myRef.addListenerForSingleValueEvent(getData)
        }
    }
}