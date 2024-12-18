package com.activity.calc

import android.view.View.OnClickListener
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomCalButton(name:String, onClick:() ->Unit){

    Box(modifier = Modifier
        .size(70.dp)
        .background(Color.Black)
        .clickable { onClick() }, contentAlignment = Alignment.Center
    ) {
     Text(text = name, fontSize = 25.sp, color = Color.White)
    }

}





