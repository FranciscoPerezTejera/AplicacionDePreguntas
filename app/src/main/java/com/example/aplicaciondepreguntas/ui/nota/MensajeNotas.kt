package com.example.aplicaciondepreguntas.ui.nota

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
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
import androidx.navigation.NavHostController
import com.example.aplicaciondepreguntas.R
import com.example.aplicaciondepreguntas.ui.ruta.Rutas
import com.example.aplicaciondepreguntas.ui.themes.MiColor

@Composable
fun PantallaMensajeNota(aciertos: Int, navController: NavHostController?) {

    val fotoAprobado: Painter = painterResource(id = R.drawable.aprobado)
    val fotoAprobadoRaspado: Painter = painterResource(id = R.drawable.aprobado_raspado)
    val fotoSuspendido: Painter = painterResource(id = R.drawable.suspendido)

    var imagenNota by remember { mutableStateOf<Painter>(fotoAprobado) }
    var textoMensaje by remember { mutableStateOf("") }

    when {
        aciertos >= 4 -> {
            imagenNota = painterResource(id = R.drawable.aprobado)
            textoMensaje = "¡ENHORABUENA!,\nHas aprobado, tu puntuación ha sido $aciertos/5\n¡FELICIDADES!"

        }
        aciertos == 3 -> {
            imagenNota = fotoAprobadoRaspado
            textoMensaje = "No está mal,\nHas aprobado muy justo, tu puntuación ha sido $aciertos/5\n¡FELICIDADES!"
        }
         aciertos < 3 -> {
            imagenNota = fotoSuspendido
            textoMensaje = "Que mal,\nHas suspendido, tu puntuación  ha sido $aciertos/5\nVUELVE A INTENTARLO"
        }
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(28, 99, 155))
    ) {
        Text(
            modifier = Modifier.padding(30.dp),
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            text = textoMensaje
        )
        Image(
            modifier = Modifier.size(450.dp),
            painter = imagenNota,
            contentDescription = ""
        )
        Button(
            onClick = {
                navController?.navigate(Rutas.PantallaPrtincipal.ruta)
            },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = MiColor
            ),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(text = "VOLVER AL MENÚ")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMensajeNotas() {
    PantallaMensajeNota(1, navController = null)
}