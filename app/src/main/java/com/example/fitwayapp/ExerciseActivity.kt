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
    lateinit var exercises:ArrayList<Exercise>
    lateinit var ex:Exercise

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        recyclerviewer = findViewById(R.id.Recyclerviewer)
        recyclerviewer.layoutManager = LinearLayoutManager(this)


        // Create a list of exercises (Replace with your actual exercise data)
        ex.name="Exercise 1"
        ex.description="Exercise 1 description"

            // Add more exercises as per your requirement

        exercises.add(Exercise("Exercise 1", "Exercise 1 description"))
        exercises.add(Exercise("Exercise 2", "Exercise 2 description"))
        exercises.add(Exercise("Exercise 3", "Exercise 3 description"))


        exerciseAdapter = ExerciseAdapter(exercises)
        recyclerviewer.adapter = exerciseAdapter

        val intent = Intent(this, WorkoutTrackingsActivity::class.java)
        startActivity(intent)
    }
}
