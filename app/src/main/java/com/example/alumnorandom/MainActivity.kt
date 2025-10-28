package com.example.alumnorandom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlumnosApp()
        }
    }
}

@Preview
@Composable
fun AlumnosApp() {
    LayoutApp()
}

@Composable
fun LayoutApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AlumnosRandom()
    }
}


@Composable
fun AlumnosRandom() {
    val alumnos = remember { mutableListOf(
        "Iván Bermejo Melia",
        "David Romero",
        "Absael Rodrigez",
        "Carlos Bermudez",
        "David Berlinches"
    ) }

    val alumnosSeleccionados = remember { mutableListOf<String>() }

    var alumnoActual by remember { mutableStateOf(alumnos.random()) }

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(120.dp)
                    .background(Color(0xFFDCE775)) // verde suave
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = alumnoActual,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF33691E)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "ALUMNOS SELECCIONADOS",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF33691E)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(200.dp)
                        .background(Color(0xFFDCE775))
                        .verticalScroll(scrollState)
                ){
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        alumnosSeleccionados.forEach { alumno ->
                            Text(
                                text = alumno,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF33691E)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {
                    if (alumnos.isNotEmpty()){
                        alumnoActual = alumnos.random()
                        alumnos.remove(alumnoActual)
                        alumnosSeleccionados.add(alumnoActual)
                    }else{
                        alumnoActual = "No quedan mas alumnos en la pull"
                    }

                }) {
                    Text("Seleccionar alumno")
                }

            }
        }
    }
}
