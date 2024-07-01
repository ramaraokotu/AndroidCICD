package com.mobile.jetpackcomposecrashcource.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobile.jetpackcomposecrashcource.R
import com.mobile.jetpackcomposecrashcource.components.ButtonComponent
import com.mobile.jetpackcomposecrashcource.components.ClickableLoginTextComponent
import com.mobile.jetpackcomposecrashcource.components.DividerComponent
import com.mobile.jetpackcomposecrashcource.components.HeadComponentText
import com.mobile.jetpackcomposecrashcource.components.MyPassWordTextFiled
import com.mobile.jetpackcomposecrashcource.components.MyTextFiled
import com.mobile.jetpackcomposecrashcource.components.NormalComponentText
import com.mobile.jetpackcomposecrashcource.components.UnderLineComponentText

@Composable
fun LoginScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorWhite))
            .padding(28.dp),
    ) {
        Column(modifier = Modifier.fillMaxSize()
        ) {

            NormalComponentText(value = stringResource(id = R.string.login))
            HeadComponentText(value = stringResource(id = R.string.welcome))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextFiled(
                labelValue = stringResource(id = R.string.email),
                icon = Icons.Outlined.Email
            )
            MyPassWordTextFiled(
                labelValue = stringResource(id = R.string.password),
                icon = Icons.Outlined.Lock
            )
            Spacer(modifier = Modifier.height(40.dp))
            UnderLineComponentText(stringResource(id = R.string.forget_password))
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(id = R.string.login))
            Spacer(modifier = Modifier.height(20.dp))
            DividerComponent()
            ClickableLoginTextComponent(false)
        }
    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}