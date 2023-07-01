package com.example.helloworldjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloworldjetpackcompose.ui.theme.HelloWorldJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HelloApp() {
    HelloWorldJetpackComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting("Totona")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExampleModifier() {
    Text(text = "Text view normal", modifier = Modifier.padding(16.dp))
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldJetpackComposeTheme {
        Greeting("Captain Arepa")
    }
}

@Preview(showBackground = true, name = "Another Preview")
@Composable
fun AnotherGreetingPreview() {
    HelloWorldJetpackComposeTheme {
        Greeting("Captain Arepa")
    }
}