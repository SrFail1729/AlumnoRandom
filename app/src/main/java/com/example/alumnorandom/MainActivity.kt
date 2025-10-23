package com.example.alumnorandom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alumnorandom.ui.theme.AlumnoRandomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Preview
@Composable
fun AlumnosApp() {
    LayoutApp()
}


@Composable
fun LayoutApp(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier.fillMaxSize()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier.width(250.dp)
                .height(200.dp)
                .background(Color.Black),

        ) {
            AlumnosDropDown()
        }
    }
}

@Composable
fun<T> SimpleDropDown(
    items: List<T>,
    selectedItem: T?,
    onItemSelected: (T) -> Unit,
    itemToString: (T) -> String,
    label: String
){
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.padding(16.dp)){
        Button(
            onClick = {expanded = true},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
            selectedItem?.let(itemToString)?: label
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {expanded = false},
            modifier = Modifier.fillMaxWidth()
        ) {
            items.forEach {
                item -> DropdownMenuItem(
                    text = { Text(itemToString(item)) },
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    }
                )
            }
        }
    }
}

 @Composable
 fun AlumnosDropDown(alumno: Alumno){
     val alumnos = remember { alumno.alumnosSeleccionados }

     var alumnoSeleccionado by remember { mutableStateOf<Alumno?>(null) }

     SimpleDropDown(
         items = alumnos,
         selectedItem = alumnoSeleccionado,
         onItemSelected = {alumnoSeleccionado = it},
         itemToString = {"${it.nombre} ${it.apellido}"},
         label = "Selecciona un alumno"
     )

    alumnoSeleccionado?.let { alumno ->
        Text(
            text = "Alumno seleccionado: ${alumno.nombre} ${alumno.apellido}",
            modifier = Modifier.padding(16.dp)
        )
    }

 }

fun cargarAlumnos(): List<Alumno> = arrayListOf(
    Alumno("David", "Romero"),
    Alumno("Giovanni","Marcano"),
    Alumno("Ivan","Bermejo"),
    Alumno("Carlos","Bermudez"),
    Alumno("Absael","Rodrigez")
)