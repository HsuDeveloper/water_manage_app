package com.example.practiceapp

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.ToggleButton


class frag1 : Fragment() {
    private lateinit var btn_water:Button
    private lateinit var text_water:TextView
    private lateinit var text_cup:TextView
    private lateinit var water_25:Button
    private lateinit var water_50:Button
    private lateinit var water_bar:ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //drink button
        btn_water = view.findViewById<Button>(R.id.water_button1)

        //show text
        text_water = view.findViewById<TextView>(R.id.water_percent1)
        text_cup = view.findViewById<TextView>(R.id.text_cup1)

        //fill button
        water_25 = view.findViewById<Button>(R.id.water25)
        water_50 = view.findViewById<Button>(R.id.water50)

        //progress bar
        water_bar = view.findViewById(R.id.water_progressBar)

        //defalut value
        text_water.setText("${water_manage.get_water()}%")
        text_cup.setText("${water_manage.get_cup()} ml")
        water_bar.progress=0

        //Click Listener

        btn_water.setOnClickListener{
            water_manage.drink_water()
            text_water.setText("${water_manage.get_water()}%")
            text_cup.setText("${water_manage.get_cup()} ml")
            water_bar.progress=water_manage.get_water()
        }

        water_25.setOnClickListener {
            water_manage.fill_cup(25)
            text_cup.setText("${water_manage.get_cup()} ml")
        }

        water_50.setOnClickListener {
            water_manage.fill_cup(50)
            text_cup.setText("${water_manage.get_cup()} ml")
        }
    }

}