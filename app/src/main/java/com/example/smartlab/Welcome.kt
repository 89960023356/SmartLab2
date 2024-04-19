@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.smartlab

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartlab.ui.theme.SmartLabTheme
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign


@Composable
fun Welcome() {
    var email: String by rememberSaveable {
        mutableStateOf("") }
    var flag = rememberSaveable {
        mutableStateOf(false)
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp, 103.dp, 20.dp, 56.dp)
    ) {
        Column {
            Text("✌  Добро пожаловать!", Modifier.padding(bottom = 23.dp), fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Войдите, чтобы пользоваться функциями приложения", fontSize = 15.sp)
            Column(Modifier.padding(top = 64.dp, bottom = 0.dp)) {
                Text("Вход по E-mail",Modifier.padding(bottom = 4.dp), fontSize = 14.sp, color = colorResource(R.color.gray))
//                val textState = remember {
//                    mutableStateOf("")
//                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                ){
                    CustomEmail(search = email, onValueChange = {it->email=it})
                }
                flag.value = email.isNotEmpty()
                val color = if(flag.value) ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.blue),
                    contentColor = colorResource(R.color.white)
                ) else ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.blue_s),
                    contentColor = colorResource(R.color.white)
                )
                Button(
                    onClick = {},
                    colors = color,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth()
                ) {
                    Text("Далее", fontSize = 17.sp, color = colorResource(R.color.white))
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
            ) {
            Text(
                "Или войдите с помощью",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                textAlign = TextAlign.Center

            )
            OutlinedButton(
                onClick = {},
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, color = colorResource(R.color.gray_p)),
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
            ) {
                Text("Войти с Яндекс", fontSize = 17.sp, color = colorResource(R.color.black))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomEmail(
    search: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp)
            .clip(RoundedCornerShape(10.dp))

    ) {
        TextField(
            value = search,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = colorResource(R.color.white_p),
                focusedIndicatorColor = Color.Transparent,
                focusedTextColor = colorResource(R.color.black),
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color(0XFF578FFF),
            ),
            modifier = Modifier.run{
                fillMaxWidth()
                },
            placeholder = {
                Text(
                    text = "example@mail.ru",
                    color = colorResource(R.color.gray_200)
                )
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun Privievka() {
    SmartLabTheme {
        Welcome()
    }
}
