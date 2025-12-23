package com.example.contractorcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.text.NumberFormat

//declaring constant tax rate, i.e. 5%
const val TAX_RATE = 0.05

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme { // using default theme for now
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContractorCalculatorScreen()
                }
            }
        }
    }
}

/*@Composable annotation to mark function as a Composable, allowing to
describe part of the UI in a declarative way using Jetpack Compose*/
@Composable
fun ContractorCalculatorScreen(modifier: Modifier = Modifier) {
    var laborInput by remember { mutableStateOf("") }
    var materialsInput by remember { mutableStateOf("") }
    var finalResult by remember { mutableStateOf(FinalResult()) }

    /*logic to perform calculation of subTotal, tax and total*/
    fun performCalculation(){

        val laborValue = laborInput.toDoubleOrNull() ?: 0.0
        val materialsValue = materialsInput.toDoubleOrNull() ?: 0.0
        val subTotal = laborValue + materialsValue
        val tax = subTotal * TAX_RATE //tax amount
        val total = subTotal + tax //total amount
        finalResult = FinalResult(subTotal, tax, total)
    }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        /*centered horizontally in the screen with the textFields on top, the button below it
        in a single row, and the TextView below the button*/
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    start = 14.dp,
                    end = 14.dp,
                    top = 44.dp,
                    bottom = 14.dp
                ),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(
                    text = "Labor:",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End,
                    modifier = Modifier.width(80.dp)
                )

                OutlinedTextField(
                    value = laborInput,
                    onValueChange = { laborInput = it },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .fillMaxWidth()
                        .height(56.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
            ) {
                Text(
                    text = "Materials:",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(80.dp)
                )

                OutlinedTextField(
                    value = materialsInput,
                    onValueChange = { materialsInput = it },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .fillMaxWidth()
                        .height(56.dp)
                )
            }

            Spacer(modifier = Modifier.height(35.dp))

            Button(
                onClick = { performCalculation() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 255, green = 255, blue = 236),
                    contentColor = Color(red = 84, green = 126, blue = 218),

                    ),
                shape = RectangleShape
            ) {
                Text(
                    text = "Calculate",
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(35.dp))

            ResultRow("SubTotal:", formatCurrency(finalResult.subTotal))
            ResultRow("Tax:", formatCurrency(finalResult.tax))
            ResultRow("Total:", formatCurrency(finalResult.total))
        }
    }
}

/*result row function to populate stored result data*/
@Composable
fun ResultRow(label: String, value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(0.5f)
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            modifier = Modifier.width(80.dp)
        )
        Text(text = value)
    }
}

/*currency formatter*/
fun formatCurrency(amount: Double): String {
    return NumberFormat.getCurrencyInstance().format(amount)
}

/*preview pane*/
//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContractorCalculatorScreenPreview() {
    MaterialTheme {
        ContractorCalculatorScreen()
    }
}