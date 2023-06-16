package com.example.labs

import android.os.Bundle
import android.util.Log
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight.Companion.Black
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.labs.constance.Constance
import com.example.labs.ui.theme.LabsTheme
import androidx.navigation.compose.rememberNavController as rememberNavController

class Lab4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var startnum = 1
        setContent {
            MaterialTheme(){ListItem(startnum, false)}

           // ListItem(2)
        }
    }
}




//@Preview (showBackground = true)
@Composable
private fun ListItem(num: Int, isAnswered: Boolean) {
    val (value, setValue) = rememberSaveable {
        mutableStateOf(num)
    }
    var counter = rememberSaveable {
        mutableStateOf(0)
    }
    //Log.i("MyLog", "Counter" + counter.toString())
    var answer : Boolean = true
    var isVisible by rememberSaveable {
        mutableStateOf( true  )
    }
    Column() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.55F)
                .padding(10.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = 5.dp,

        ) {
            Box(
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(modifier = Modifier
                        .padding(2.dp), fontSize = 18.sp, fontWeight = Black
                        ,text = "Вопрос № $value")
                    Text(modifier = Modifier
                        .padding(5.dp), fontSize = 18.sp
                        ,text = Constance.QUIZ_QUESTION_MAP[value].toString())
                    Image(
                        painter = rememberAsyncImagePainter(Constance.QUIZ_IMAGE_MAP[value]),
                        contentDescription = null,
                        modifier = Modifier .fillMaxWidth()
                    )

                    }
                }

            }
        AnimatedVisibility(isVisible) {
            Row() {
                ExtendedFloatingActionButton(
                    modifier = Modifier
                        .fillMaxWidth(0.5F)
                        .padding(10.dp),
                    onClick = {
                        answer = false
                        if (answer == Constance.QUIZ_ANSWER_MAP[value]) {
                            counter.value = counter.value + 1
                            Log.i("MyLog", counter.toString())
                        }
                        isVisible = ! isVisible
                    },
                    icon = {
                        Icon(
                            Icons.Filled.Close,
                            contentDescription = "Ложь"
                        )
                    },
                    text = { Text("Ложь") },
                    shape = RoundedCornerShape(5.dp),
                    backgroundColor = Color.Red
                )
                ExtendedFloatingActionButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                    ,
                    onClick = {
                        answer = true
                        if (answer == Constance.QUIZ_ANSWER_MAP[value]){
                            counter.value = counter.value + 1
                            Log.i("MyLog", counter.toString())
                        }
                        isVisible=!isVisible
                    },
                    icon = {
                        Icon(
                            Icons.Filled.Done,
                            contentDescription = "Правда"
                        )
                    },
                    text = { Text("Правда") },
                    shape = RoundedCornerShape(5.dp),
                    backgroundColor = Color.Green
                )
            }
        }
        AnimatedVisibility(!isVisible) {
            if (value < Constance.QUIZ_QUESTION_MAP.size) {
                Row() {
                    ExtendedFloatingActionButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        onClick = {
                            setValue(value + 1)
                            isVisible = !isVisible
                        },
                        icon = {
                            Icon(
                                Icons.Filled.ArrowForward,
                                contentDescription = "Вперед"
                            )
                        },
                        text = { Text("Вперед") },
                        shape = RoundedCornerShape(5.dp),
                        backgroundColor = Color.Gray
                    )
                }
            }
            else if (value >= Constance.QUIZ_QUESTION_MAP.size && !isVisible)Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            )
            {
                Text(modifier = Modifier
                    .padding(5.dp), fontSize = 18.sp,
                    text = "Количество правильных ответов ${counter.value}")

            }
        }

        }
    }





