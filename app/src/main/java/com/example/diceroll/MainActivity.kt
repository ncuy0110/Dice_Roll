package com.example.diceroll

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnRoll = findViewById<Button>(R.id.btnRoll)
        btnRoll.setOnClickListener{
            rollDice()
        }

    }
    private fun rollDice(){
        fun check(a: Int) = when(a){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        val randomeInt1 = Random().nextInt(6)+1
        val diceImageView0 = findViewById<ImageView>(R.id.dice_image0)
        diceImageView0.setImageResource(check(randomeInt1))

        val randomeInt2 = Random().nextInt(6)+1
        val diceImageView1 = findViewById<ImageView>(R.id.dice_image1)
        diceImageView1.setImageResource(check(randomeInt2))

        val randomeInt3 = Random().nextInt(6)+1
        val diceImageView2 = findViewById<ImageView>(R.id.dice_image2)
        diceImageView2.setImageResource(check(randomeInt3))

        val result = findViewById<TextView>(R.id.tvResult)
        result.setText((randomeInt1+randomeInt2+randomeInt3).toString())
    }
}