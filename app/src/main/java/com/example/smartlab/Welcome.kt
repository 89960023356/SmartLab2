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
    var email: String by remember {
        mutableStateOf("") }
    var flag = remember {
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
                val textState = remember {
                    mutableStateOf("")
                }
//                OutlinedTextField(value = textState.value,
//                    onValueChange = {textState.value = it},
//                    shape = RoundedCornerShape(10.dp),
//                    singleLine = true,
//                    modifier = Modifier.run {
//                        fillMaxWidth()
//                            .padding(bottom = 32.dp)
//                            .background(color = colorResource(R.color.white_p))
//                    },
//                    placeholder = {
//                        Text(
//                            "example@mail.ru",
//                            color = colorResource(R.color.gray_200)
//                        )
//                    }
//                )
                CustomEmail(search = email, onValueChange = {it->email=it})
                flag.value = email.isNotEmpty()
                val color = if(flag.value) ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.blue),
                    contentColor = colorResource(R.color.white)
                ) else ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.blue_s),
                    contentColor = colorResource(R.color.white)
                )
                ButtonExit()
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
            ButtonAnother()
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
            .background(Color(0XFFE8EFFF))

    ) {
        TextField(
            value = search,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0XFFE8EFFF),
                focusedIndicatorColor = Color.Blue,
                focusedTextColor = Color(0XFF578FFF),
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color(0XFF578FFF),
            ),
            modifier = Modifier.fillMaxWidth().background(Color(0XFFF5F5F9)).clip(RoundedCornerShape(10.dp)),
            placeholder = {
                Text(
                    text = "example@mail.ru",
                    color = Color(0XFF578FFF)
                )
            }
        )

    }
}



//@Composable
//fun TextField() {
//    val textState = remember {
//        mutableStateOf("")
//    }
//    OutlinedTextField(value = textState.value,
//        onValueChange = {textState.value = it},
//        shape = RoundedCornerShape(10.dp),
//        singleLine = true,
//        modifier = Modifier.run {
//            fillMaxWidth()
//                .padding(bottom = 32.dp)
//                .background(color = colorResource(R.color.white_p))
//        },
//        placeholder = {
//            Text(
//                "example@mail.ru",
//                color = colorResource(R.color.gray_200)
//            )
//        }
//    )
//}
@Composable
fun ButtonExit() {
    Column {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(colorResource(R.color.blue_s)),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
        ) {
            Text("Далее", fontSize = 17.sp, color = colorResource(R.color.white))
        }
    }
}
@Composable
fun ButtonAnother() {
    Column {
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

@Preview(showBackground = true)
@Composable
fun Privievka() {
    SmartLabTheme {
        Welcome()
    }
}
