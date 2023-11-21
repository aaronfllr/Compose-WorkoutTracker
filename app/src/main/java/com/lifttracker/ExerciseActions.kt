package com.lifttracker

sealed class ExerciseActions {
    data class Exercise(val string: String): ExerciseActions()
    object Add: ExerciseActions()
}