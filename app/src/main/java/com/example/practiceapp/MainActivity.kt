package com.example.practiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment(0)

        val state_switch = findViewById<ToggleButton>(R.id.state)
        val btn1 = findViewById<Button>(R.id.btn_page1)
        val btn2 = findViewById<Button>(R.id.btn_page2)
        val btn3 = findViewById<Button>(R.id.btn_setting)

        state_switch.setOnClickListener{
            if(state_switch.isChecked()){
                state_switch.setBackgroundResource(R.drawable.btn_star_big_on)
                setFragment(1)
            }
            else{
                state_switch.setBackgroundResource(R.drawable.btn_star_big_off)
                setFragment(0)
            }
        }

        btn1.setOnClickListener {
            water_manage.fill_cup(25)
        }

        btn2.setOnClickListener {
            water_manage.fill_cup(50)
        }

    }

    private fun setFragment(fragNum:Int){
        val fragM = supportFragmentManager.beginTransaction()
        when(fragNum){
            0-> {fragM.replace(R.id.main_frame,frag1()).commit()}
            1-> {fragM.replace(R.id.main_frame,frag2()).commit()}
        }

    }
}