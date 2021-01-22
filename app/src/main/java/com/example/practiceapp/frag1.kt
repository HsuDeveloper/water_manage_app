package com.example.practiceapp

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class frag1 : Fragment() {
    private lateinit var btn_water:Button
    private lateinit var text_water:TextView
    private lateinit var text_cup:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_water = view.findViewById<Button>(R.id.water_button1)
        text_water = view.findViewById<TextView>(R.id.water_percent1)
        text_cup = view.findViewById<Button>(R.id.text_cup1)

        text_water.setText("${water_manage.get_water()}%")
        text_cup.setText("${water_manage.get_cup()} ml")
        

        btn_water.setOnClickListener{
            water_manage.drink_water()
            text_water.setText("${water_manage.get_water()}%")
            text_cup.setText("${water_manage.get_cup()} ml")
        }
    }

}