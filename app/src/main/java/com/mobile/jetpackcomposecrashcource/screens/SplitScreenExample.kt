package com.mobile.jetpackcomposecrashcource.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SplitScreenExample() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.Red)
            ) {
                Column( modifier = Modifier.fillMaxSize().align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly) {
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Button1")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Button2")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Button3")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Button4")
                    }
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.Gray)
            ) {
                // Bottom half view content
                Row (modifier = Modifier.fillMaxSize().align(Alignment.Center),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly){
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Button1")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Button2")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Button3")
                    }
                }
            }
        }
    }
}
