package com.example.thirdprojekcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thirdprojekcompose.ui.theme.ThirdProjekComposeTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirdProjekComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConfirmationPreview()
                }
            }
        }
    }
}

@Composable
fun Confirmation(t1: String,t2:String,modifier: Modifier = Modifier) {
    val image= painterResource(id = R.drawable.ic_task_completed)
    Column(horizontalAlignment=Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = t1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top=24.dp, bottom = 8.dp)

        )
        Text(
            text = t2,
            fontSize = 16.sp

        )
    }

}

@Preview(showBackground = true)
@Composable
fun ConfirmationPreview() {
    ThirdProjekComposeTheme {
        Confirmation(t1 = "All tasks completed", t2 ="Nice work!" )
    }
}