package com.example.practiceapp

import android.icu.text.DecimalFormat
import android.os.Build
import androidx.annotation.RequiresApi
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ViewPortHandler

public class MyValueFormatter: ValueFormatter() {
    private val dates = arrayOf("20210303","20210304","20210305")
    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
        return dates.getOrNull(value.toInt()-1)?:value.toString()
    }
}