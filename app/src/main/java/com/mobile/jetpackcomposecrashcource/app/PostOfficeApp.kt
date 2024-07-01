package com.mobile.jetpackcomposecrashcource.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mobile.jetpackcomposecrashcource.screens.LoginScreen
import com.mobile.jetpackcomposecrashcource.screens.SignUpScreen
import com.mobile.jetpackcomposecrashcource.screens.SplitScreenExample

@Composable
fun PostOfficeApp() {
    Surface(modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        //SignUpScreen()
        //LoginScreen()
        SplitScreenExample()
    }
}