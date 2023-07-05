@file:OptIn(
    ExperimentalMaterial3Api::class
)

package com.example.helloworldjetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.WindowInsets
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
        }
    }
}

// TOOLBAR AND WOTNOT

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true)
fun ViewContainer() {
    Scaffold(
        topBar = { Toolbar() },
        floatingActionButton = { FAButton() },
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValues ->
        Content(modifier = Modifier.padding(paddingValues))
    }
}

@Composable
fun FAButton() {
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        Toast.makeText(context, "Mensaje", Toast.LENGTH_SHORT).show()
    }) {
        Text("X")
    }
}

@Composable
@Preview
fun Toolbar() {
    TopAppBar(
        title = { Text(text = "App Toolbar", color = colorResource(id = R.color.white)) },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Red
        )
    )
}

// COLUMNS & ROWS

@Composable
@Preview(showBackground = true)
fun Content(modifier: Modifier = Modifier) {
    // STATE
    // Here we're creating a value counter with an initial state (zero), and we're setting it to
    // be remembered (persistable)
    // remember -> saves in the current lifecycle state (i.e. rotates and value resets
    // rememberSaveable -> saves throught all lifecycle states (i.e. can rotate and value remains)
    var counter by rememberSaveable {
        mutableStateOf(0)
    }
    // COLUMS
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(16.dp)
    ) {
        item {
            Image(painter = painterResource(id = R.drawable.mayoshino), contentDescription = null)
            Row(modifier = Modifier.padding(8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "like",
                    modifier = Modifier.clickable { counter++ }
                )
                Text(
                    text = counter.toString(),
                    color = Color.White,
                    modifier = Modifier.padding(4.dp)
                )
            }
            Text(
                text = "Title",
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = "Content", color = Color.White)
            Text(text = "Footer", color = Color.White)
            // ROWS
            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                item {
                    Text(text = "Row Title", color = Color.White)
                    Text(text = "Row Content", color = Color.White)
                    Text(text = "Row Footer", color = Color.White)
                    Text(text = "Random Item", color = Color.White)
                    Text(text = "Random Item", color = Color.White)
                    Text(text = "Random Item", color = Color.White)
                    Text(text = "Random Item", color = Color.White)
                    Text(text = "Random Item", color = Color.White)
                    Text(text = "Random Item", color = Color.White)
                    Text(text = "Random Item", color = Color.White)
                    Text(text = "Random Item", color = Color.White)
                }

            }
        }
    }

}