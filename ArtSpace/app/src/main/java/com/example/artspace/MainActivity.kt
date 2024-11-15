package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceCard()
            }
        }
    }
}

fun calculateIndex(curIndex: Int, next: Boolean): Int {
    return if (next) {
        if (curIndex == arts.lastIndex) {
            0
        } else {
            curIndex + 1
        }
    } else {
        if (curIndex == 0) {
            arts.lastIndex
        } else {
            curIndex - 1
        }
    }
}

@Composable
fun ArtSpaceCard() {
    // 记录下标即可
    var index by remember { mutableIntStateOf(0) }
    val art = arts[index]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .height(300.dp)
                .border(1.dp, Color(228, 226, 229)),
            color = Color.White,
            tonalElevation = 50.dp,
            border = BorderStroke(20.dp, Color.White)
        ) {
            Image(
                painter = painterResource(art.image),
                contentDescription = null,
                modifier = Modifier.border(1.dp, Color.Green),
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(236, 235, 244))
                .padding(15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(text = art.title, style = MaterialTheme.typography.titleLarge, fontSize = 30.sp)
            Row(modifier = Modifier.padding(top = 10.dp)) {
                Text(
                    text = art.author,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "(%d)".format(art.year))
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { index = calculateIndex(index, false) }) { Text(text = "Previous") }
            Button(onClick = { index = calculateIndex(index, true) }) { Text(text = "Next") }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceCard()
    }
}