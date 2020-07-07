package com.apps.malpv.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    // La inicialización se da posteriormente
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencia al botón y se asigna a una variable inmutable
        val rollButton: Button = findViewById(R.id.button_roll)
        diceImage = findViewById(R.id.imgDice)

        //  Modifique dinámicamente la vista del botón
        rollButton.text = "Let's Roll"

        rollButton.setOnClickListener{
            Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
            rollDice()
        }

    }

    private fun rollDice() {
        // Obtener un número aleatorio entre 1 y 6
        val randomInt = Random().nextInt(6) + 1

        // Se elije el recurso extraíble adecuado en función del valor de randomInt
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }
}
