package com.example.practiceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class frag2 : Fragment() {
    private lateinit var btn_water: Button
    private lateinit var text_water: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_water = view.findViewById<Button>(R.id.water_button2)
        text_water = view.findViewById<TextView>(R.id.water_percent2)
        text_water.setText("${water_manage.get_water()}%")

        btn_water.setOnClickListener{
            water_manage.drink_water()
            text_water.setText("${water_manage.get_water()}%")
        }
    }
}