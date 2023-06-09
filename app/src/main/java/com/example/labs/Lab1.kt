package com.example.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.text.isDigitsOnly
import com.example.labs.databinding.ActivityLab1Binding
import com.example.labs.databinding.ActivityMainBinding
import java.lang.Math.sqrt

class Lab1 : AppCompatActivity() {
    lateinit var bdCl : ActivityLab1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bdCl = ActivityLab1Binding.inflate(layoutInflater)
        setContentView(bdCl.root)
    }
    override fun onResume() {
        super.onResume()
        Log.i ("MyLog", "Запущено activity L1")
    }

    fun OnClickReturnToMenu(view: View) {
        val intent = Intent(this,MainActivity::class.java) //объявление активити для перехода
        startActivity(intent) //запуск активити
    }
    fun OnClickSolveL1(view: View) {
        val input = bdCl.dataInput.editableText.toString()
        var data = input.split(" ").toMutableList() //запись в список данных из textinputview с разделителем " "
        Log.i("MyLog", data.toString())
        if (data.size == 4) {
            if (data.last() == "a") {
                data.removeLast()
                var average = 0.0
                for (num in data) {
                    if (num.isDigitsOnly()) ////проверка на "дурака" (все данные в списке - числа)
                        average += num.toDouble()
                    else {
                        bdCl.textView2.text = "Ошибка. Проверьте правильность введенных данных"
                        data.clear()
                        break
                    }
                }
                if (data.isNotEmpty()){
                    average /= data.size
                    bdCl.textView2.text = average.toString()
                }
            }
            else if (data.last() == "g") {
                data.removeLast()
                var geom = 1.0
                for (num in data) {
                    if (num.isDigitsOnly()) //проверка на "дурака" (все данные в списке - числа)
                        geom*=num.toDouble()
                    else {
                        bdCl.textView2.text = "Ошибка. Проверьте правильность введенных данных"
                        data.clear()
                        break
                    }
                }
                if (data.isNotEmpty()) {
                    geom = kotlin.math.sqrt(geom)
                    bdCl.textView2.text = geom.toString()
                }
            }
            else {
                bdCl.textView2.text = "Ошибка. Проверьте исходные данные(последний символ)"
            }
        }
        else {
            bdCl.textView2.text = "Ошибка. Проверьте исходные данные(количество чисел)"
        }
        }

    }
