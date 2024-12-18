package com.activity.calc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.activity.calc.ui.theme.CalcTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalcView()
        }
    }
}

@Composable
fun CalcView() {
    var inputValue by remember { mutableStateOf("0") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(text = "How much would you like to send?", color = Color.White,  modifier = Modifier.fillMaxWidth(),  textAlign = TextAlign.Center )
        Text(text = inputValue, fontSize = 50.sp, color = Color.White,  modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center )

        val buttons = listOf(
            listOf("1", "2", "3"),
            listOf("4", "5", "6"),
            listOf("7", "8", "9"),
            listOf(".", "0", "DEL")
        )
        buttons.forEach { buttonRow ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                buttonRow.forEach { button ->
                    CustomCalButton(button, onClick = { inputValue = handleInputValue(inputValue, button) })
                }
            }

        }
    }
}

fun handleInputValue(inputString: String, buttonKey: String): String {
    return when (buttonKey) {
        "DEL" -> if (inputString.length > 1) inputString.dropLast(1) else "$0"
        else -> {
            var num = "0"
                if(inputString.length > 1){
              num =  inputString.substring(0, inputString.length-3).replace("[,$]".toRegex(), "")
            }


            NumberFormat.getCurrencyInstance().format((num+buttonKey).toInt())}
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalcTheme {
        CalcView()
    }
}