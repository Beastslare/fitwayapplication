package com.example.fitwayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import com.example.fitwayapp.ProgressActivity


class WorkoutTrackingsActivity : AppCompatActivity() {
    private var exerciseName: String = ""
    private var repetitions: Int = 0
    private var exerciseCount: Int = 0
    lateinit var tx_ExerciseName:TextView
    lateinit var tx_Repetion:TextView
    lateinit var et_exerciseName:EditText
    lateinit var et_repetition:EditText
    lateinit var progressBar:ProgressBar
    lateinit var btnStart:Button
    lateinit var btnStop:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_trackings)
        et_repetition = findViewById(R.id.etRepetition)
        et_exerciseName = findViewById(R.id.etExerciseName)
        tx_Repetion = findViewById(R.id.txRepetition)
        tx_ExerciseName = findViewById(R.id.txExerciseName)
        btnStop = findViewById(R.id.btnstop)
        btnStart = findViewById(R.id.btnstart)

        btnStart.setOnClickListener {
            startTracking()
        }

        btnStop.setOnClickListener {
            stopTracking()
        }
    }
    private fun startTracking() {
        exerciseName = et_exerciseName.text.toString()
        repetitions = et_repetition.text.toString().toInt()

        // Clear input fields
        et_exerciseName.text.clear()
        et_repetition.text.clear()

        exerciseCount = 0
        updateExerciseCount()

        // Start tracking the workout
        // You can implement the logic to track the workout, update the timer, etc.

        // Update the progress bar
        progressBar.max = repetitions
        progressBar.progress = exerciseCount
    }

    private fun stopTracking() {
        // Stop tracking the workout
        // You can implement the logic to stop the workout, save the data, etc.
    }

    private fun updateExerciseCount() {
        exerciseCount++


        // Update the progress bar
        progressBar.progress = exerciseCount

        // Check if the workout is completed
        if (exerciseCount == repetitions) {
            // Workout completed, perform necessary actions
        }
        val intent = Intent(this, ProgressActivity::class.java)
        startActivity(intent)
    }
}