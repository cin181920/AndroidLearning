        package com.example.lemonapp

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonapp.ui.theme.LemonAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonAppTheme {
                LemonTreePreview()
                //LemonPreview()
                //LemonDrinkPreview()
                //LemonEmptyPreview()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Lemon_Tree(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {
    var nextslide by remember{ mutableStateOf(1) }
    var squeezecount by remember{ mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade Simple Apps",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
        }


    }


    when(nextslide) {
        1 -> Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Image(
                painter = painterResource(id = R.drawable.lemon_tree),
                contentDescription = null,
                modifier = Modifier.wrapContentSize().clickable {
                    nextslide= 2
                    squeezecount=(2..4).random()
                }
            )


            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.Lemon_tree),
                fontSize = 20.sp,
                textAlign = TextAlign.Center

            )
        }


        2-> Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
            Image(
                painter = painterResource(id = R.drawable.lemon_squeeze),
                contentDescription = null,
                modifier = Modifier.wrapContentSize().clickable {
                    squeezecount--
                    if (squeezecount == 0) {
                        nextslide= 3
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.Lemon),
                fontSize = 20.sp,
                textAlign = TextAlign.Center

            )
        }

        3-> Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
            Image(
                painter = painterResource(id = R.drawable.lemon_drink),
                contentDescription = null,
                modifier = Modifier.wrapContentSize().clickable {nextslide= 4 }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.Glass_of_lemonade),
                fontSize = 20.sp,
                textAlign = TextAlign.Center

            )
        }

        4-> Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
            Image(
                painter = painterResource(id = R.drawable.lemon_restart),
                contentDescription = null,
                modifier = Modifier.wrapContentSize().clickable {nextslide= 1 }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.Empty_glas),
                fontSize = 20.sp,
                textAlign = TextAlign.Center

            )
        }
    }


}





@Preview()
@Composable
fun LemonTreePreview() {
    LemonAppTheme {
        Lemon_Tree()
    }
}
