package com.example.fitwayapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ExerciseAdapter(private val exerciseList: ArrayList<Exercise>) :
    RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.itemexercise, parent, false)
        return ExerciseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val currentExercise = exerciseList[position]
        holder.txtExerciseName.text = currentExercise.name
        holder.txtExerciseDescription.text = currentExercise.description
    }

    override fun getItemCount(): Int {
        return exerciseList.size
    }

    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        public val txtExerciseName: TextView = itemView.findViewById(R.id.tvExerciseName)
        public val txtExerciseDescription: TextView =
            itemView.findViewById(R.id.tvExerciseDescription)
        data class Exercise(val name: String, val description: String)

        fun bind(exercise: com.example.fitwayapp.Exercise) {
            txtExerciseName.text = exercise.name
            txtExerciseDescription.text = exercise.description
        }
    }
}
