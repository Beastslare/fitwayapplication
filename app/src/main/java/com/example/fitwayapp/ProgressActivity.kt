package com.example.fitwayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.DropBoxManager.Entry
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.google.firebase.ktx.Firebase


class ProgressActivity : AppCompatActivity(), OnChartValueSelectedListener {
    private lateinit var lineChart: LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        lineChart = findViewById(R.id.lineChart)

        // Configure the line chart
        configureLineChart()

        // Add data to the line chart
        addDataToLineChart()
    }

    private fun configureLineChart() {
        // Customize the appearance of the line chart
        lineChart.setNoDataText("No data available")
        lineChart.setOnChartValueSelectedListener(this)

        val description = Description()
        description.text = "Progress Chart"
        lineChart.description = description
    }

    private fun addDataToLineChart() {
        val entries = mutableListOf<com.github.mikephil.charting.data.Entry>()
        entries.add(com.github.mikephil.charting.data.Entry(1.0f, 50f))
        entries.add(com.github.mikephil.charting.data.Entry(2f, 80f))
        entries.add(com.github.mikephil.charting.data.Entry(3f, 60f))
        entries.add(com.github.mikephil.charting.data.Entry(4f, 70f))
        entries.add(com.github.mikephil.charting.data.Entry(5f, 90f))

        val dataSet = LineDataSet(entries, "Progress")
        val lineData = LineData(dataSet)
        lineChart.data = lineData
        lineChart.invalidate()
    }

    override fun onValueSelected(e: com.github.mikephil.charting.data.Entry?, h: Highlight?) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected() {
        // Handle when nothing is selected on the chart
    }
}