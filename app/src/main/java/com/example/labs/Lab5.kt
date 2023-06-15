package com.example.labs

//import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ToggleButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import coil.compose.rememberAsyncImagePainter
import com.example.labs.constance.Constance
import com.example.labs.ui.theme.LabsTheme
import org.intellij.lang.annotations.JdkConstants.TitledBorderJustification
import kotlin.math.absoluteValue

class Lab5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            calcView()
            }
        }
    }

@Composable
fun calcView() {
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(Constance.PHOTO_SIZE_MAP[1]) }
    var quantity by remember { mutableStateOf("") }
    var selCost by remember { mutableStateOf(0.0)}

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                    .padding(10.dp)
                     //   .border(width = 1.dp, color = androidx.compose.ui.graphics.Color.Black),
                ) {
                Column(
                    modifier = Modifier
                        //.selectableGroup()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
//                      .border(width = 1.dp, color = androidx.compose.ui.graphics.Color.Black)
                ) {
                        Text(text = "Размер", fontSize = 18.sp)
                        Constance.PHOTO_SIZE_MAP.forEach { content ->
                            Row(
                                Modifier
                                    .fillMaxWidth(0.5F)
                                    .height(56.dp)
                                ,
                                verticalAlignment = Alignment.CenterVertically
                            )
                            {
                                RadioButton(
                                    selected = (content.value == selectedOption),
                                    onClick = {
                                        onOptionSelected(content.value)
                                        Log.i("MyLog", content.key.toString())
                                        //Log.i("MyLog", "Опция " + setSize.toString())
                                    }

                                )
                                Text(modifier = Modifier .padding(2.dp), text = content.value, fontSize = 22.sp)

                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                Column(
                    modifier = Modifier
                        .selectableGroup()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
//                      .border(width = 1.dp, color = androidx.compose.ui.graphics.Color.Black)
                ) {
                    Text(text = "Стоимость", fontSize = 18.sp)
                        Constance.PHOTO_SIZE_MAP.forEach { text ->
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .height(56.dp),
                                verticalAlignment = Alignment.CenterVertically
                            )
                            {
                                Text(
                                    text = "${Constance.PHOTO_COST_MAP[text.key].toString()}₽",
                                    fontSize = 22.sp
                                )
                               // selCost=Constance.PHOTO_COST_MAP[text.key].toDouble()
                            }
                        }
                    }
                }
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
                    ) {
                TextField(
                    modifier = Modifier.fillMaxWidth(0.7F),
                    value = quantity,
                    onValueChange = {
                        newValue -> quantity =  newValue
                    },
                    label = { Text("Кол-во снимков") },
                    singleLine = true,
                    placeholder = {Text("0")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                ExtendedFloatingActionButton(
                    modifier = Modifier
                        .fillMaxWidth(0.5F)
                        //.fillMaxHeight()
                        .padding(2.dp),
                    onClick = {
                        if (quantity.isDigitsOnly() && quantity.toInt()>0)
                        {
                            quantity = (quantity.toInt()-1).toString()
                        }
                        else if (quantity=="") {quantity = "0"}
                        Log.i("MyLog", "- quantity ${quantity}") },
                    text = { Text("–") },
                    shape = RoundedCornerShape(5.dp)
                    //, backgroundColor = androidx.compose.ui.graphics.Color.Yellow
                )
                ExtendedFloatingActionButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        //.fillMaxHeight()
                        .padding(2.dp),
                    onClick = {
                        if (quantity!="" && quantity.isDigitsOnly())
                        {
                            quantity = (quantity.toInt()+1).toString()
                        }
                        else if (quantity == "")
                        {
                            quantity = "0"
                            quantity = (quantity.toInt()+1).toString()
                        }
                        Log.i("MyLog", selectedOption.toString()) },
                    text = { Text("+") },
                    shape = RoundedCornerShape(5.dp)
                    //, backgroundColor = androidx.compose.ui.graphics.Color.Yellow
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                var cost = 0.0
                if (quantity=="") { Text(text = "Стоимость: 0₽", fontSize = 32.sp) }
                else {
                    //Log.i("MyLog", "Опция "+setSize.toString())
                    //Log.i("MyLog", "ЦЕНА "+Constance.PHOTO_COST_MAP[setSize].toString())
                    Text(text = "Стоимость: " +
                            "${
                                //quantity.toDouble() * Constance.PHOTO_SIZE_COST_MAP[selectedOption.toString()]!!
                                //quantity //* Constance.PHOTO_COST_MAP[setSize]
                                quantity
                                //quantity*Constance.PHOTO_COST_MAP[Constance.PHOTO_SIZE_MAP[selectedOption]]
                            }₽", fontSize = 32.sp) }
                //Log.i("MyLog", "1 " + com.example.labs.constance.Constance.PHOTO_COST_MAP[setSize].toString())
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                ExtendedFloatingActionButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    onClick = {},
                    icon = { Icon(Icons.Filled.Send, contentDescription = "Pay!")
                    },
                    text = { Text("Распечатать") },
                    shape = RoundedCornerShape(5.dp)
                    //, backgroundColor = androidx.compose.ui.graphics.Color.Yellow
                )
            }

        }
    }
}


