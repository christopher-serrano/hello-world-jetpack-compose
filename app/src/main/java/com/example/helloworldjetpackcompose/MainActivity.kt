package com.example.helloworldjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloworldjetpackcompose.ui.theme.HelloWorldJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnApp()
        }
    }
}

// COLUMNS

@Composable
@Preview(showBackground = true)
fun ColumnApp() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        item {

            Image(painter = painterResource(id = R.drawable.mayoshino), contentDescription = null)
            Text(
                text = "Title",
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = "Content", color = Color.White)
            Text(text = "Footer", color = Color.White)
        }
    }


}

// INIT TUTORIAL

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