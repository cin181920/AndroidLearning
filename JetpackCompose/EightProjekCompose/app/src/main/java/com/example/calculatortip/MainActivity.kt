package com.example.calculatortip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatortip.ui.theme.CalculatorTipTheme
import java.nio.file.WatchEvent
import java.text.NumberFormat
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTipTheme {
              TipCalulatePreview()
            }
        }
    }
}

@Composable
fun TipCalculate() {
    var amountInput by remember{ mutableStateOf("") }
    var tipInput by remember { mutableStateOf("") }
    var roundUp by remember { mutableStateOf(false) }
    val amount=amountInput.toDoubleOrNull()?:0.0
    val tipPercent=tipInput.toDoubleOrNull()?:0.0

    val tip= Calculate(amount,tipPercent,roundUp)

    Column(modifier= Modifier
        .statusBarsPadding()
        .padding(horizontal = 40.dp)
        .verticalScroll(rememberScrollState())
        .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        Text(
            text = stringResource(R.string.calculate_tip),
            modifier= Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )

        EditNumberField(label=R.string.bill_amount,leadingIcon = R.drawable.baseline_money_24,value=amountInput,onValueChange={amountInput=it},modifier = Modifier
            .padding(bottom = 32.dp)
            .fillMaxWidth())

        if(roundUp) {
            EditNumberField(
                label = R.string.calculate_tip,leadingIcon = R.drawable.baseline_percent_24,
                value = tipInput,
                onValueChange = { tipInput = it },
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )
        }
        Button(onClick = { tip}) {
            Text(
                text ="HITUNG",
                fontSize = 16.sp

            )
        }

        Spacer(modifier=Modifier.height(50.dp))
        RoundTheTipRow(roundUp=roundUp, onRoundUpChanged ={roundUp=it} )

        Spacer(modifier=Modifier.height(60.dp))
        Text(text = stringResource(id = R.string.tip_amount,tip.toString()),style=MaterialTheme.typography.displaySmall, textAlign = TextAlign.Center)
        Spacer(modifier=Modifier.height(150.dp))
    }
}

@Composable
fun EditNumberField(@StringRes label:Int, @DrawableRes leadingIcon:Int,value:String, onValueChange:(String)->Unit, modifier:Modifier=Modifier){
    TextField(
        value=value,
        onValueChange=onValueChange,
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
        label = { Text(stringResource(label)) },
        modifier=modifier
    )
}





@Composable
fun RoundTheTipRow(roundUp:Boolean,onRoundUpChanged:(Boolean)->Unit,modifier:Modifier=Modifier){
    Row(modifier= modifier
        .fillMaxWidth()
        .size(48.dp), verticalAlignment = Alignment.CenterVertically){

        Text(text = stringResource(id = R.string.round_up_tip) )

        Switch(
            checked = roundUp,
            onCheckedChange =onRoundUpChanged,
            modifier= modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
        )
    }

}

private fun Calculate(jumlah:Double,tipPercent:Double,roundUp: Boolean): String {
    var tip=tipPercent/100 * jumlah
    if(roundUp){
        tip=kotlin.math.ceil(tip)
        return NumberFormat.getCurrencyInstance().format(tip)
    }else{
        return NumberFormat.getCurrencyInstance().format(jumlah)
    }

}





@Preview()
@Composable
fun TipCalulatePreview() {
    CalculatorTipTheme {
    TipCalculate()
    }
}