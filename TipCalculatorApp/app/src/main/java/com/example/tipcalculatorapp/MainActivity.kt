package com.example.tipcalculatorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculatorapp.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.PI
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        // Best way with view binding and no extra variable
        // binding.myButton.text = "A button"

        binding.calculateButton.setOnClickListener {
            calculateTip()
        }

        binding.btnProceed.setOnClickListener {
            val intent = Intent(this, TipTime::class.java)
            startActivity(intent)
        }

        // mainResult()
    }

    private fun calculateTip(){
        val stringInTextField = binding.costOfServiceEditText.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        if(cost == null || cost == 0.0){
            displayTip(0.0)
            return
        }
        var tip = tipPercentage * cost

        //For a `Switch` element, you can check the `isChecked` attribute to see if the switch is "on".
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        // Display the formatted tip value on screen
        displayTip(tip)

    }

    private fun displayTip(tip : Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}


    //---- for test abstraction
/*
    fun mainResult() {
        val squareCabin = SquareCabin(6, 50.0)
        val roundHut = RoundHut(3, 10.0)
        val roundTower = RoundTower(4, 15.5)

        with(squareCabin) {
            println("\nSquare Cabin\n============")
            println("Capacity: ${capacity}")
            println("Material: ${buildingMaterial}")
            println("Floor area: ${floorArea()}")
        }

        with(roundHut) {
            println("\nRound Hut\n=========")
            println("Material: ${buildingMaterial}")
            println("Capacity: ${capacity}")
            println("Floor area: ${floorArea()}")
            println("Has room? ${hasRoom()}")
            getRoom()
            println("Has room? ${hasRoom()}")
            getRoom()
            println("Carpet size: ${calculateMaxCarpetSize()}")
        }

        with(roundTower) {
            println("\nRound Tower\n==========")
            println("Material: ${buildingMaterial}")
            println("Capacity: ${capacity}")
            println("Floor area: ${floorArea()}")
            println("Carpet size: ${calculateMaxCarpetSize()}")
        }
    }


    /**
     * Defines properties common to all dwellings.
     * All dwellings have floorspace,
     * but its calculation is specific to the subclass.
     * Checking and getting a room are implemented here
     * because they are the same for all Dwelling subclasses.
     *
     * @param residents Current number of residents
     */
    abstract class Dwelling(private var residents: Int) {
        abstract val buildingMaterial: String
        abstract val capacity: Int

        /**
         * Calculates the floor area of the dwelling.
         * Implemented by subclasses where shape is determined.
         *
         * @return floor area
         */
        abstract fun floorArea(): Double

        /**
         * Checks whether there is room for another resident.
         *
         * @return true if room available, false otherwise
         */
        fun hasRoom(): Boolean {
            return residents < capacity
        }

        /**
         * Compares the capacity to the number of residents and
         * if capacity is larger than number of residents,
         * add resident by increasing the number of residents.
         * Print the result.
         */
        fun getRoom() {
            if (capacity > residents) {
                residents++
                println("You got a room!")
            } else {
                println("Sorry, at capacity and no rooms left.")
            }
        }

    }

    /**
     * A square cabin dwelling.
     *
     *  @param residents Current number of residents
     *  @param length Length
     */
    class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
        override val buildingMaterial = "Wood"
        override val capacity = 6

        /**
         * Calculates floor area for a square dwelling.
         *
         * @return floor area
         */
        override fun floorArea(): Double {
            return length * length
        }

    }

    /**
     * Dwelling with a circular floorspace
     *
     * @param residents Current number of residents
     * @param radius Radius
     */
    open class RoundHut(
            val residents: Int, val radius: Double) : Dwelling(residents) {

        override val buildingMaterial = "Straw"
        override val capacity = 4

        /**
         * Calculates floor area for a round dwelling.
         *
         * @return floor area
         */
        override fun floorArea(): Double {
            return PI * radius * radius
        }

        /**
         *  Calculates the max length for a square carpet
         *  that fits the circular floor.
         *
         * @return length of carpet
         */
        fun calculateMaxCarpetSize(): Double {
            val diameter = 2 * radius
            return sqrt(diameter * diameter / 2)
        }

    }

    /**
     * Round tower with multiple stories.
     *
     * @param residents Current number of residents
     * @param radius Radius
     * @param floors Number of stories
     */
    class RoundTower(
            residents: Int,
            radius: Double,
            val floors: Int = 2) : RoundHut(residents, radius) {

        override val buildingMaterial = "Stone"

        // Capacity depends on the number of floors.
        override val capacity = floors * 4

        /**
         * Calculates the total floor area for a tower dwelling
         * with multiple stories.
         *
         * @return floor area
         */
        override fun floorArea(): Double {
            return super.floorArea() * floors
        }
    }
}

 */