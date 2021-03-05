package com.example.practiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ToggleButton
import androidx.room.Room


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment(0)

        val btn3 = findViewById<Button>(R.id.btn_setting)



    }

    private fun setFragment(fragNum:Int){
        val fragM = supportFragmentManager.beginTransaction()
        when(fragNum){
            0-> {fragM.replace(R.id.main_frame,frag1()).commit()}
        }

    }
}