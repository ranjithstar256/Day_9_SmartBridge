package com.example.day9smartbridge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.ListenableWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.day9smartbridge.ui.theme.Day9SmartBridgeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Day9SmartBridgeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    lateinit var workManager: WorkManager
                    //Greeting("Android")
                    Column {
                        Button(onClick = {
                            workManager = WorkManager.getInstance(applicationContext)

                            val myWorkRequest: WorkRequest =  OneTimeWorkRequestBuilder<WorkrClas>()
                                .build()
                            workManager.enqueue(myWorkRequest)
                        }) {

                        }
                    }

                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Day9SmartBridgeTheme {
        Greeting("Android")
    }
}