package com.example.aplicaciondepreguntas.ui.modonormal

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.aplicaciondepreguntas.R

@Composable
fun PantallaModoNormal (navController : NavHostController?) {

    val contexto = LocalContext.current

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()){

        Text(text = "HOLA")
        Image(
            painter = painterResource(id = R.drawable.logo_preguntas),
            contentDescription = "",
            modifier = Modifier
                .size(200.dp))

        Row {
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(8.dp)) {
                Text(text = "VERDADERO")
                
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(8.dp)) {
                Text(text = "FALSO")
                
            }
        }
        Row {
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(8.dp)) {
                Text(text = "PREV")
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(8.dp)) {
                Text(text = "NEXT")
            }
        }
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewModoNormal(){
    PantallaModoNormal(navController = null)
}