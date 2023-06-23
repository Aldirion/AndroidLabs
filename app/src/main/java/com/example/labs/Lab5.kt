package com.example.labs

//import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
//import androidx.lifecycle.ViewModel
import com.example.labs.constance.Constance
//import androidx.lifecycle.viewmodel.compose.viewModel


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
    val (selectedOption, onOptionSelected) = rememberSaveable { mutableStateOf(Constance.PHOTO_SIZE_MAP[1]) }
    var quantity by rememberSaveable { mutableStateOf("") }
    var selCost by rememberSaveable { mutableStateOf(0.0) }
    var setSize by rememberSaveable { mutableStateOf(1) }
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            //"""Выбор параметров снимка"""
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            //.selectableGroup()
                            .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Размер", fontSize = 18.sp)
                        Constance.PHOTO_SIZE_MAP.forEach { content ->
                            Row(
                                Modifier
                                    .fillMaxWidth(0.5F)
                                    .height(56.dp),
                                verticalAlignment = Alignment.CenterVertically
                            )
                            {
                                RadioButton(
                                    selected = (content.value == selectedOption),
                                    onClick = {
                                        onOptionSelected(content.value)
                                        Log.i("MyLog", content.key.toString())
                                        setSize = content.key
                                    }
                                )
                                Text(
                                    modifier = Modifier.padding(2.dp),
                                    text = content.value,
                                    fontSize = 22.sp
                                )
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
                            }
                        }
                    }
                }
            }
           // """Строка ввода количества снимков"""
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                //Поле ввода
                TextField(
                    modifier = Modifier.fillMaxWidth(0.7F),
                    value = quantity,
                    onValueChange = { newValue ->
                        quantity = newValue
                    },
                    label = { Text("Кол-во снимков") },
                    singleLine = true,
                    placeholder = { Text("0") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                //Кнопка "-"
                ExtendedFloatingActionButton(
                    modifier = Modifier
                        .fillMaxWidth(0.5F)
                        //.fillMaxHeight()
                        .padding(2.dp),
                    onClick = {
                        if (quantity.isDigitsOnly() && quantity.toInt() > 0) {
                            quantity = (quantity.toInt() - 1).toString()
                        } else if (quantity == "") {
                            quantity = "0"
                        }
                        Log.i("MyLog", "- quantity ${quantity}")
                    },
                    text = { Text("–") },
                    shape = RoundedCornerShape(5.dp)
                )
                //Кнопка "+"
                ExtendedFloatingActionButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp),
                    onClick = {
                        if (quantity != "" && quantity.isDigitsOnly()) {
                            quantity = (quantity.toInt() + 1).toString()
                        } else if (quantity == "") {
                            quantity = "0"
                            quantity = (quantity.toInt() + 1).toString()
                        }
                        Log.i("MyLog", selectedOption.toString())
                    },
                    text = { Text("+") },
                    shape = RoundedCornerShape(5.dp)
                )
            }
           // """Финальная стоимость"""
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                if (quantity == "") {
                    Text(text = "Стоимость: 0₽", fontSize = 32.sp)
                } else if (quantity.toDouble() < 0) {
                    Text(text = "Ошибка. Некорректные кол-во снимков", fontSize = 32.sp)
                } else {
                    selCost = Constance.PHOTO_COST_MAP[setSize]?.toDouble() ?: 100.0
                    Text(
                        text = "Стоимость: " + "${quantity.toDouble() * selCost}₽",
                        fontSize = 32.sp
                    )
                }
            }
           // """Кнопка оплаты"""
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ExtendedFloatingActionButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    onClick = {},
                    icon = {
                        Icon(Icons.Filled.Send, contentDescription = "Pay!")
                    },
                    text = { Text("Распечатать") },
                    shape = RoundedCornerShape(5.dp),
                    backgroundColor = androidx.compose.ui.graphics.Color.Yellow
                )
            }
        }
    }
}

