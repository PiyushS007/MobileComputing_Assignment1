package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Column {
                    Select_List()

                }
            }


        }
    }
}


@Preview
@Composable
fun PreviewMyAppMC() {
    Select_List()
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyAppMC(stops: List<String>, df: List<Int>) {

    var current by remember { mutableStateOf(0) }
    var isKm by remember { mutableStateOf(true) }




    val DisinKm=df
    val disinMiles = DisinKm.map { it * 0.621371 }

    val currentStop = stops[current]
    val CurrDistance = if (isKm) DisinKm[current] else disinMiles[current]
    val totalDistance = DisinKm.subList(0, stops.size - 1).sum()
    val Distancetill = DisinKm.subList(0, current).sum() // Adjusted total distance calculation
    val distanceLeft = DisinKm.subList(current, stops.size - 1).sum() // Adjusted distance left calculation

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(text = "Journey Progress")
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Current Stop: $currentStop")
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Distance to Next Stop: $CurrDistance ${if (isKm) "km" else "miles"}")
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Total Distance Covered till: $Distancetill km")
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Total Distance: $totalDistance km")
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Total Distance Left: $distanceLeft km")
                Spacer(modifier = Modifier.height(16.dp))
                LinearProgressIndicator(
                    progress = (totalDistance - distanceLeft).toFloat() / totalDistance.toFloat(),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    if (current < stops.size - 1) {
                        current++
                    }
                }) {
                    Text(text = "Next Stop")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    isKm = !isKm
                }) {
                    Text(text = "Switch Units")
                }
                Spacer(modifier = Modifier.height(32.dp))
                Text("List of Stops:")
                if( stops.size<=10)
                {
                    StaticList(stops = stops)
                }
                else
                {
                    Lazyone(stops = stops)
                }

            }
        }
    )
}

@Composable
fun StaticList(stops: List<String>) {
    stops.forEach { stop ->
        Text(text = stop)
    }
}

@Composable
fun Lazyone(stops: List<String>) {
    LazyColumn {
        items(stops.size) { index ->
            Text(text = stops[index])
        }
    }
}


@Composable
fun Select_List() {
    val stops = listOf(
        "Delhi",
        "Mathura",
        "Agra",
        "Gurgoan",
        "Noida",
        "lucknow",
        "Dhampur",
        "Bijnor",
        "Rishikesh",
        "Haridwar"
    )

    val stopsLazy = List(20) { "Stop ${it+1}" }

    val d1 = listOf(5, 8, 12, 17, 20, 27, 30, 37, 40, 0)
    val d2 = listOf(5, 8, 14, 16, 20, 24, 30, 35, 40, 56, 15, 18, 12, 15, 20, 25, 30, 35, 40, 0)

    var sl by remember { mutableStateOf(true) }


    Column {
        Button(onClick = {
            sl = !sl
             // Reset current when switching lists
        }) {
            Text(text = "Switch lists", fontSize = 16.sp)
        }

        val selectedStops = if (sl) stops else stopsLazy
        val selectedDistances = if (sl) d1 else d2
        key(sl) {
            MyAppMC(stops = selectedStops, df = selectedDistances)
        }


    }
}









