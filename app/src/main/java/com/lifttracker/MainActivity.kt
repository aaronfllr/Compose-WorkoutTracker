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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(16.dp)
//
//                ) {
//                    Card() {
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth()
//
//                        ) {
//                            OutlinedTextField(
//                                value = exerciseName,
//                                label = { Text(text = "Exercise")},
//                                onValueChange = { text ->
//                                    exerciseName = text
//                                },
//                                modifier = Modifier.weight(1f)
//
//                            )
//                            Spacer(modifier = Modifier.width(16.dp))
//                            Button(onClick = {
//                                if(exerciseName.isNotBlank()) {
//                                    exerciseNames = exerciseNames + exerciseName
//                                    exerciseName = ""
//                                }
//                            }) {
//                                Text(text = "Add")
//                            }
//                        }
//                    }
//
//                    ExerciseList(exerciseNames = exerciseNames)
//                }
            centerScaffoldExamplePreview()

            }
        }
    }
}





@Composable
fun Add() {
    Button(onClick = {
        println("button clicked")
    }) {
        Text(text = "Add")
    }
}
//@Composable
//fun CardMinimalExample() {
//    Card() {
//        Text(text = "Hello, world!")
//    }
//}


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ExerciseListPreview() {
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
        Card() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()

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
        }

        ExerciseList(exerciseNames = exerciseNames)
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Preview
//@Composable
//fun AddExerciseDialog(
//    onDismiss: () -> Unit,
//    onDoneClick: () ->Unit
//) {
//    var exerciseName: String by remember {
//    mutableStateOf("")
//}
//    var exerciseNames by remember {
//        mutableStateOf(listOf<String>())
//    }
//    var text: String by remember {
//        mutableStateOf("")
//    }
//
//    AlertDialog(
//        onDismissRequest = { onDismiss() },
//        title = {
//            Text("Add Exercise")
//        },
//        text = {
//
//            OutlinedTextField(
//                value = exerciseName,
//                label = { Text(text = "Exercise") },
//                onValueChange = { text ->
//                    exerciseName = text
//                },
//                modifier = Modifier.fillMaxWidth(),
//
//                )
//        },
//        confirmButton = {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//
//            ){
//                IconButton(onClick = { onDoneClick() }) {
//                    conten
//                }
//            }
//
//        },
//}
