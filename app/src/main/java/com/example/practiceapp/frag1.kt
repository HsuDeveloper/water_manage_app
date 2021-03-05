package com.example.practiceapp

import android.app.Activity
import android.graphics.Color
import android.graphics.Color.green
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.ToggleButton
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry


class frag1 : Fragment() {
    private lateinit var btn_water:Button
    private lateinit var btn_mode:ToggleButton
    private lateinit var text_water:TextView
    private lateinit var text_cup:TextView
    private lateinit var water_25:Button
    private lateinit var water_50:Button
    private lateinit var water_bar:ProgressBar
    private lateinit var water_chart:BarChart
    private lateinit var water_data:ArrayList<BarEntry>

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
        btn_mode = view.findViewById<ToggleButton>(R.id.delete_toggle)
        //state
        if(btn_mode.isChecked()){
            btn_water.setText("Substract\nWater")
        }
        else{
            btn_water.setText("Drink\nWater")
        }
        //show text
        text_water = view.findViewById<TextView>(R.id.water_percent1)
        text_cup = view.findViewById<TextView>(R.id.text_cup1)

        //fill button
        water_25 = view.findViewById<Button>(R.id.water25)
        water_50 = view.findViewById<Button>(R.id.water50)

        //progress bar
        water_bar = view.findViewById(R.id.water_progressBar)

        //declare chart
        water_chart = view.findViewById(R.id.water_chart)

        //defalut value
        text_water.setText("${water_manage.get_water()}%")
        text_cup.setText("${water_manage.get_cup()} ml")
        water_bar.progress=0

        //Click Listener

        btn_water.setOnClickListener{
            if(btn_mode.isChecked()) {
                water_manage.substract_water()
                text_water.setText("${water_manage.get_water()}%")
                text_cup.setText("${water_manage.get_cup()} ml")
                water_bar.progress = water_manage.get_water()
            }
            else{
                water_manage.drink_water()
                text_water.setText("${water_manage.get_water()}%")
                text_cup.setText("${water_manage.get_cup()} ml")
                water_bar.progress = water_manage.get_water()
            }
        }

        water_25.setOnClickListener {
            water_manage.fill_cup(25)
            text_cup.setText("${water_manage.get_cup()} ml")
        }

        water_50.setOnClickListener {
            water_manage.fill_cup(50)
            text_cup.setText("${water_manage.get_cup()} ml")
        }

        //state
        btn_mode.setOnClickListener(){
            if(btn_mode.isChecked()){
                btn_water.setText("Substract\nWater")
            }
            else{
                btn_water.setText("Drink\nWater")
            }
        }
        //chart

        water_data = ArrayList<BarEntry>()
        water_data.add(BarEntry(1.2f,250f))
        water_data.add(BarEntry(2.2f,170f))
        water_data.add(BarEntry(3.2f,270f))

        val water_dataset = BarDataSet(water_data,"water (ml)")

        val data = BarData(water_dataset)
        water_chart.data = data
        water_dataset.color = resources.getColor(R.color.water_blue)

        water_chart.run {
            setDrawBarShadow(true) // 그래프 그림자
            setTouchEnabled(false) // 차트 터치 막기
            setDrawValueAboveBar(true) // 입력?값이 차트 위or아래에 그려질 건지 (true=위, false=아래)
            setPinchZoom(false) // 두손가락으로 줌 설정
            setDrawGridBackground(false) // 격자구조
            setMaxVisibleValueCount(10) // 그래프 최대 갯수
            description.isEnabled = false // 그래프 오른쪽 하단에 라벨 표시
            legend.isEnabled = false // 차트 범례 설정(legend object chart)

            xAxis.run { // 아래 라벨 x축
                isEnabled = true // 라벨 표시 설정
                position = XAxis.XAxisPosition.BOTTOM // 라벨 위치 설정
                valueFormatter = MyValueFormatter() // 라벨 값 포멧 설정
                setDrawGridLines(false) // 격자구조
                granularity = 1.2f // 간격 설정
                setDrawAxisLine(false) // 그림
                textSize = 12f // 라벨 크기
                textColor = Color.BLUE
            }

            animateY(1500) // y축 애니메이션
        }
    }

}

