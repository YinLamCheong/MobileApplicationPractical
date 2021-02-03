package com.example.basicandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cake()
    }
    fun cake(){
        val age = 20
        val name = "Rover"
        val border = "`-._,-'"
        val timesToRepeat = 4
        val layers = 5

        printBorder(border,timesToRepeat)
        println("Happy Birthday, ${name}!")
        printBorder(border, timesToRepeat)

        // Let's print a cake!
        printCakeTop(age)
        printCakeCandles(age)
        printCakeBottom(age, layers)

        // This prints an empty line.
        println("")

        println("You are already ${age}!")
        println("${age} is the very best age to celebrate!")
    }

    fun printBorder(border:String, times:Int) {
        repeat(times) {
            print(border)
        }
        println()
    }

    fun printCakeTop(age: Int) {
        repeat(age + 2) {
            print("=")
        }
        println()
    }

    fun printCakeCandles(age: Int) {
        print (" ")
        repeat(age) {
            print(",")
        }
        println() // Print an empty line

        print(" ") // Print the inset of the candles on the cake
        repeat(age) {
            print("|")
        }
        println()
    }
    fun printCakeBottom(age: Int, layers: Int) {
        repeat(age + 2) {
            print("@")
        }
        println()
    }

}