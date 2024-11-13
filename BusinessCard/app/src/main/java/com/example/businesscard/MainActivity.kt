package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(color = Color(210, 232, 212), modifier = Modifier.fillMaxSize()) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Spacer(Modifier.height(100.dp))
        MainCard()
        ContactCard()
    }
}

@Composable
fun MainCard() {
    // 主体信息
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .align(Alignment.CenterHorizontally)
                .background(color = Color(7, 48, 66)),
        )

        Text(
            text = "XiangLin",
            fontSize = 30.sp,
            lineHeight = 40.sp,
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "Software Development Engineer",
            color = Color(29, 122, 74),
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
fun ContactCard() {
    // 联系信息
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        ContactItem(Icons.Rounded.Phone, "phone", "+86 15360056461")
        ContactItem(Icons.Rounded.Share, "share", "https://blog.xianglin.store")
        ContactItem(Icons.Rounded.Email, "email", "xianglin2020@outlook.com")
    }
}

@Composable
fun ContactItem(
    icon: ImageVector,
    iconDesc: String,
    content: String
) {
    // 联系方式
    Row {
        Spacer(Modifier.width(60.dp))
        Icon(icon, contentDescription = iconDesc, tint = Color(0, 109, 59))
        Spacer(Modifier.width(10.dp))
        Text(text = content)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        Surface(color = Color(210, 232, 212), modifier = Modifier.fillMaxSize()) {
            BusinessCard()
        }
    }
}