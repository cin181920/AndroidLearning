package com.example.fiveprojekcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fiveprojekcompose.ui.theme.FiveProjekComposeTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FiveProjekComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardcompanyPreview()
                }
            }
        }
    }
}

@Composable
fun CardCompany(
    fullname: String,
    judul:String,
    notelp:String,
    sosmed:String,
    email:String,
    modifier: Modifier = Modifier) {
val image= painterResource(id = R.drawable.logo)

    Column (verticalArrangement =Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,modifier=Modifier.padding(16.dp)) {
     Row {
      Image(
          painter = image,
          contentDescription =null,
          modifier= Modifier
              .width(200.dp)
              .height(200.dp)
      )
     }

        Text(
             text =fullname,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier=Modifier.padding(16.dp)
        )

        Text(
            text =judul,
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            color=Color(0xFF029C47),
            textAlign =TextAlign.Center

        )

        Column (modifier = Modifier.padding(60.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Row {

                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription =null,
                    modifier=Modifier.padding(end =8.dp)
                )
                Text(
                    text =notelp,
                    fontSize = 16.sp,
                    textAlign =TextAlign.Center
                )

            }

            Row {

                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription =null,
                    modifier=Modifier.padding(end =8.dp)
                )
                Text(
                    text =sosmed,
                    fontSize = 16.sp,
                    textAlign =TextAlign.Center
                )
            }


            Row {

                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription =null,
                    modifier=Modifier.padding(end =8.dp)
                )
                Text(
                    text =email,
                    fontSize = 16.sp,
                    textAlign =TextAlign.Center
                )
            }
        }
    }







}


@Preview(showBackground = true)
@Composable
fun CardcompanyPreview() {
    FiveProjekComposeTheme {
      CardCompany(fullname = "Android Jetpack Compose", judul ="By Google Company","+12345678910112","@androiddeveloper","androideveloper@gmail.com")
    }
}