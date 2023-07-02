package com.example.fitwayapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ExerciseAdapter(private val exerciseList: ArrayList<Exercise>) :
    RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itemexercise, parent, false)
        return ExerciseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val currentExercise = exerciseList[position]
        holder.bind(currentExercise)
    }

    override fun getItemCount(): Int {
        return exerciseList.size
    }

    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtExerciseName: TextView = itemView.findViewById(R.id.tvExerciseName)
        val txtExerciseDescription: TextView = itemView.findViewById(R.id.tvExerciseDescription)

        fun bind(exercise: Exercise) {
            txtExerciseName.text = exercise.name
            txtExerciseDescription.text = exercise.description
        }
    }
    data class Exercise(val name: String, val description: String)
}
