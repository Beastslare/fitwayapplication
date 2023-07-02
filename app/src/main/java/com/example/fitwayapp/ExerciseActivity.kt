package com.example.fitwayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitwayapp.WorkoutTrackingsActivity
import java.lang.reflect.Array

class ExerciseActivity : AppCompatActivity() {
    lateinit var recyclerviewer:RecyclerView
    private lateinit var exerciseAdapter:ExerciseAdapter
    private lateinit var exercises: ArrayList<ExerciseAdapter.Exercise>
    private lateinit var ex: Exercise

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        recyclerviewer = findViewById(R.id.Recyclerviewer)
        recyclerviewer.layoutManager = LinearLayoutManager(this)

        // Create a list of exercises (Replace with your actual exercise data)
        exercises = ArrayList()

        // Add more exercises as per your requirement
        exercises.add(ExerciseAdapter.Exercise("Exercise 2", "Exercise 2 description"))
        exercises.add(ExerciseAdapter.Exercise("Exercise 3", "Exercise 3 description"))

        exerciseAdapter = ExerciseAdapter(exercises)
        recyclerviewer.adapter = exerciseAdapter

        val intent = Intent(this, WorkoutTrackingsActivity::class.java)
        startActivity(intent)
    }
}
