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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun DialogAddExercise(onDismiss: () -> Unit, viewModel: AddExercise = viewModel()) {
    var exerciseName: String by remember {
        mutableStateOf("")
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
                            viewModel.addToList(exerciseName)
                            
                            exerciseName = ""
                        }
                    }
                ) {
                    Text(text = "Add")
                }
            }
        }
    }


}

class AddExercise : ViewModel() {

    var exerciseNames = mutableListOf<String>()

    fun addToList(exercise: String) {

            exerciseNames.add(exercise)

    }
}