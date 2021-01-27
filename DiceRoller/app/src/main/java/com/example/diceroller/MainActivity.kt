package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollBtn: Button = findViewById(R.id.button)

        rollBtn.setOnClickListener {
            //display toast message(a temporarily display message)
            //val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

            // Do a dice roll when the app starts
            rollDice()
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val rollResult = dice.roll()

        // Find the ImageView in the layout
        var diceImage: ImageView = findViewById(R.id.imageViewDice)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResources = when (rollResult) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResources)

        // Update the content description
        diceImage.contentDescription = rollResult.toString()

        /* // see whether can get the lucky number
        val luckyNumber = 4

         when (rollResult){
             luckyNumber -> println("You win! ")
             1 -> println("So sorry! You rolled a 1. Try again! ")
             2 -> println("Sadly, you rolled a 2. Try again! ")
             3 -> println("Unfortunately, you rolled a 3. Try again!")
             4 -> println("No luck! You rolled a 4. Try again!")
             5 -> println("Apologies! You rolled a 5. Try again!")
             6 -> println("Don't cry! You rolled a 6. Try again!")
         }

         */

        /*
        if(rollResult == luckyNumber){
            println("You Win !")
        }else if(rollResult == 1){
            println("So sorry! You rolled a 1. Try again!")
        }else if(rollResult == 2){
            println("Sadly, you rolled a 2. Try again!")
        }else if(rollResult == 3){
            println("Unfortunately, you rolled a 3. Try again!")
        }else if(rollResult == 4){
            println("No luck! You rolled a 4. Try again!")
        }else if(rollResult == 5){
            println("Apologies! You rolled a 5. Try again!")
        }else if(rollResult == 6){
            println("Don't cry! You rolled a 6. Try again!")
        }
         */


    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}