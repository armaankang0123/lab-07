package com.example.lab_7

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.compose.ui.text.style.TextAlign
@Composable
fun DriversScreen(navController: NavController){
    var name by remember{ mutableStateOf("") }
    val drivers= remember { mutableStateListOf<String>()}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text("FormulaZero Drivers")


        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.testTag("driversBackButton")
        ) { Text("Go Back to Homescreen") }
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Driver's Name") },
            modifier = Modifier.fillMaxWidth().testTag("inputDriver")
        )
        Button(
            onClick = {
                if (name.isNotBlank()) {
                    drivers.add(name.trim())
                    name = ""
                }
            },
            modifier = Modifier.testTag("addButtonDriver")
        ) { Text("Add a Driver: ") }
        Button(
            onClick = { drivers.clear() },
            modifier = Modifier.testTag("clearButtonDriver")
        ) { Text("Clear all drivers") }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "List of Drivers",
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyColumn {
            items(drivers) {driver ->
                Text(
                    text = driver,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                )

                HorizontalDivider()
            }

        }
    }

}