package com.example.aplicaciondepreguntas.ui.modonormal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplicaciondepreguntas.R
import com.example.aplicaciondepreguntas.ui.themes.MiColor

@Composable
fun PantallaMensajeNota(aciertos : Int) {

    var imagenNota : Painter
    var textoMensaje : String

    if (aciertos == 5) {
        textoMensaje = "¡ENORABUENA!,\nHas aprobado con la máxima nota.\nFELICIDADES"
        imagenNota = painterResource(id = R.drawable.aprobado)
    } else if (aciertos == 3) {
        textoMensaje = "No esta mal,\nHas aprobado muy justo, pero has aprobado\nFELICIDADES"
        imagenNota = painterResource(id = R.drawable.aprobado_raspado)
    } else {
        textoMensaje = "Que mal,\nHas suspendido, pero no te desanimes\nVuelve a intentarlo"
        imagenNota = painterResource(id = R.drawable.suspendido)
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(28, 99, 155))
    ) {
        Text(modifier = Modifier
            .padding(30.dp),
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            text =  textoMensaje)
        Image(modifier = Modifier
            .size(450.dp),
            painter = imagenNota, contentDescription = "")
        Button(onClick = { },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = MiColor
            ),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()) {
            Text(text = "VOLVER AL MENÚ")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMensajeNotas() {
    PantallaMensajeNota(1)
}