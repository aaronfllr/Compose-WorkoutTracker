package com.lifttracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lifttracker.ui.theme.LiftTrackerTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LiftTrackerTheme {
                var exerciseName: String by remember {
                    mutableStateOf("")
                }
                var exerciseNames by remember {
                    mutableStateOf(listOf<String>())
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = exerciseName,
                            label = { Text(text = "Exercise")},
                            onValueChange = { text ->
                                exerciseName = text
                            },
                            modifier = Modifier.weight(1f)

                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(onClick = {
                            if(exerciseName.isNotBlank()) {
                                exerciseNames = exerciseNames + exerciseName
                                exerciseName = ""
                            }
                        }) {
                            Text(text = "Add")
                        }
                     }
                    ExerciseList(exerciseNames = exerciseNames)
                }
            }
        }
    }
}


@Composable
fun ExerciseList(
    exerciseNames: List <String>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(exerciseNames) {currentExercise ->
            Text(
                text = currentExercise,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Divider()
        }
    }

}