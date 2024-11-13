package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrant()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            QuadrantCard(
                Color(0xFFEADDFF),
                Modifier.weight(1F),
                "Text composable",
                "Displays text and follows the recommended Material Design guidelines."
            )
            QuadrantCard(
                Color(0xFFD0BCFF),
                Modifier.weight(1F),
                "Image composable",
                "Creates a composable that lays out and draws a given Painter class object."
            )
        }
        Row(Modifier.weight(1f)) {
            QuadrantCard(
                Color(0xFFB69DF8),
                Modifier.weight(1F),
                "Row composable",
                "A layout composable that places its children in a horizontal sequence."
            )
            QuadrantCard(
                Color(0xFFF6EDFF),
                Modifier.weight(1F),
                "Column composable",
                "A layout composable that places its children in a vertical sequence."
            )
        }
    }
}

@Composable
fun QuadrantCard(color: Color, modifier: Modifier, funcName: String, funcDesc: String) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = funcName,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(text = funcDesc, textAlign = TextAlign.Justify)
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant()
    }
}