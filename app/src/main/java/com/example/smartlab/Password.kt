package com.example.smartlab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smartlab.ui.theme.SmartLabTheme

@Composable
fun Password() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp, 232.dp, 20.dp, 428.dp)) {
        Text("Введите код из E-mail", modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
            textAlign = TextAlign.Center)

    }
}

@Preview(showBackground = true)
@Composable
fun Privievk() {
    SmartLabTheme {
        Password()
    }
}