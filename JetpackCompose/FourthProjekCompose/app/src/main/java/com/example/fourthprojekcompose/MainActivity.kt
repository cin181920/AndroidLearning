package com.example.fourthprojekcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fourthprojekcompose.ui.theme.FourthProjekComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FourthProjekComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadranAppPreview()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp() {
   Column(Modifier.fillMaxSize()) {
       Row(Modifier.weight(1f)){
       ComposableInfoCard(
           judul = stringResource(id = R.string.first_title) ,
           deskripsi = stringResource(id = R.string.first_description) ,
           backgroundColor =Color(0xFFEADDFF),
           modifier=Modifier.weight(1f)
           )
        ComposableInfoCard(
            judul = stringResource(id = R.string.second_title) ,
            deskripsi = stringResource(id = R.string.second_description) ,
            backgroundColor =Color(0xFFD0BCFF),
            modifier=Modifier.weight(1f)
        )
       }
       Row(Modifier.weight(1f)){
           ComposableInfoCard(
               judul = stringResource(id = R.string.third_title) ,
               deskripsi = stringResource(id = R.string.third_description) ,
               backgroundColor =Color(0xFFB69DF8),
               modifier=Modifier.weight(1f)
           )
           ComposableInfoCard(
               judul = stringResource(id = R.string.fourth_title) ,
               deskripsi = stringResource(id = R.string.fourth_description) ,
               backgroundColor =Color(0xFFF6EDFF),
               modifier=Modifier.weight(1f)
           )
       }
   }
}

@Composable
private fun ComposableInfoCard(
    judul:String,
    deskripsi:String,
    backgroundColor: Color,
    modifier:Modifier=Modifier
){
    Column(modifier= modifier
        .fillMaxSize()
        .background(backgroundColor)
        .padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
     Text(
         text = judul,
         modifier=Modifier.padding(bottom=16.dp),
         fontWeight = FontWeight.Bold
     )
        Text(
            text = deskripsi,
            textAlign = TextAlign.Center
        )
    }
}
@Preview(showBackground = true)
@Composable
fun ComposeQuadranAppPreview() {
    FourthProjekComposeTheme {
       ComposeQuadrantApp()
    }
}