package com.lifttracker


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.window.Dialog

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun DialogAddExercise(onDismiss: () -> Unit): List<String> {
    var exerciseName: String by remember {
        mutableStateOf("")
    }
    var exerciseNames by remember {
        mutableStateOf(listOf<String>())
    }
    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = exerciseName,
                    label = { Text(text = "Exercise") },
                    onValueChange = { text ->
                        exerciseName = text
                    },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = {
                        if (exerciseName.isNotBlank()) {
                            exerciseNames = exerciseNames + exerciseName
                            exerciseName = ""
                        }
                    }
                ) {
                    Text(text = "Add")
                }
            }
        }
    }
    return exerciseNames
}