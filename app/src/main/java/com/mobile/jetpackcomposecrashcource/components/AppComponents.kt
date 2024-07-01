package com.mobile.jetpackcomposecrashcource.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.jetpackcomposecrashcource.R
import com.mobile.jetpackcomposecrashcource.ui.theme.Primary

@Composable
fun NormalComponentText(value: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(40.dp),
        text = value,
        textAlign = TextAlign.Center,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
        )
        , color = colorResource(id = R.color.colorText)
    )

}

@Composable
fun HeadComponentText(value: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        text = value,
        textAlign = TextAlign.Center,
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
        )
        , color = colorResource(id = R.color.colorText)
    )

}

@Composable
fun MyTextFiled(labelValue: String, icon: ImageVector) {
    val textValue = remember {
       mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        label = { Text(text = labelValue)},
        value = textValue.value,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary)
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        onValueChange = {
        textValue.value = it },
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = "")
        }
    )
}

@Composable
fun MyPassWordTextFiled(labelValue: String, icon: ImageVector) {
    val localFocusManager = LocalFocusManager.current

    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        label = { Text(text = labelValue)},
        value = password.value,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions{
            localFocusManager.clearFocus()
        },
        singleLine = true,
        maxLines = 1,
        onValueChange = {
            password.value = it },
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = "")
        },
        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = null)
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}


@Composable
fun CheckBoxComponent(value: String) {
  Row(modifier = Modifier
      .fillMaxWidth()
      .heightIn(),
      verticalAlignment = Alignment.CenterVertically
  ) {
      val checkSate = remember {
          mutableStateOf(false)
      }
      Checkbox(checked = checkSate.value, onCheckedChange = {
          checkSate.value != checkSate.value
      } )
      ClickableTextComponent(value = value)
  }
}

@Composable
fun ClickableTextComponent(value: String) {
    val initialText = "By Continuing you accept our "
    val privacyPolicyText = "Privacy Policy"
    val andText = " and "
    val termsAndConditionsText = "Term of Use"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.colorPrimary))) {
            pushStringAnnotation(tag = privacyPolicyText, annotation =  privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.colorPrimary))) {
            pushStringAnnotation(tag = termsAndConditionsText, annotation =  termsAndConditionsText)
            append(termsAndConditionsText)
        }

        }

      ClickableText(text = annotatedString, onClick = { offset ->
          annotatedString.getStringAnnotations(offset, offset)
              .firstOrNull()?.also { span ->
                  Log.d("ClickableTextComponent","{$span}")
              }


      })
    }

@Composable
fun ButtonComponent(value: String) {
    Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
      Box (modifier = Modifier
          .fillMaxWidth()
          .heightIn(48.dp)
          .background(
              brush = Brush.horizontalGradient(
                  listOf(
                      colorResource(id = R.color.colorPrimary), colorResource(
                          id = R.color.colorPrimary
                      )
                  )
              ),
              shape = RoundedCornerShape(50.dp)
          ),
             contentAlignment = Alignment.Center
          ) {
             Text(text = value,
                 fontSize = 18.sp,
                 textAlign = TextAlign.Center,
                 fontWeight = FontWeight.Normal)
           }
    }
}

@Composable
fun DividerComponent() {
    Row (modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically){

        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = colorResource(id = R.color.colorGray),
            thickness = 1.dp)
       
        Text(modifier = Modifier.padding(8.dp),
            text = "OR",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.colorGray),
            fontStyle = FontStyle.Normal,
        )

        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = colorResource(id = R.color.colorGray),
            thickness = 1.dp)
    }
}

@Composable
fun ClickableLoginTextComponent(tryingToLogin: Boolean = true) {
    val initialText = if(tryingToLogin) "Already have an account? " else "Don't have an account yet? "
    val login = if(tryingToLogin) "Login" else "Register"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.colorPrimary))) {
            pushStringAnnotation(tag = login, annotation =  login)
            append(login)
        }
    }

    ClickableText(modifier = Modifier
        .fillMaxWidth()
        .heightIn(40.dp),
        style = TextStyle(
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent","{$span}")
            }


    })
}

@Composable
fun UnderLineComponentText(value: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(40.dp),
        text = value,
        textAlign = TextAlign.Center,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textDecoration = TextDecoration.Underline
        )
        , color = colorResource(id = R.color.colorText)
    )
}

@Composable
fun NavigationDrawerText(title: String, textUnit: TextUnit, color: Color) {

    val shadowOffset = Offset(4f, 6f)

    Text(
        text = title, style = TextStyle(
            color = Color.Black,
            fontSize = textUnit,
            fontStyle = FontStyle.Normal,
            shadow = Shadow(
                color = Primary,
                offset = shadowOffset, 2f
            )
        )
    )
}