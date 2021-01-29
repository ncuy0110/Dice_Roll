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
        fun getViewDrawableByName(name: String): Int =
                try {
                    R.drawable::class.java.getField(name).getInt(null)
                } catch (e: NoSuchFieldException){
                    0
                }
        fun getViewIdByName(name: String): Int? =
                try {
                    R.id::class.java.getField(name).getInt(null)
                } catch (e: NoSuchFieldException){
                    null
                }
        val imgView = arrayOfNulls<ImageView>(10)
        var sum = 0
        for (i in 0..2){
            val id = getViewIdByName("dice_image$i")
            id?: continue
            imgView[i] = findViewById<ImageView>(id)
            val random = Random().nextInt(6)+1
            sum+=random
            imgView[i]?.setImageResource(getViewDrawableByName("dice_$random"))
        }
        val result = findViewById<TextView>(R.id.tvResult)
        result.setText(sum.toString())
    }
}