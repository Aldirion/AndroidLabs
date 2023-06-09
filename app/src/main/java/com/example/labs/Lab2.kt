package com.example.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.text.isDigitsOnly
import com.example.labs.databinding.ActivityLab2Binding
import kotlin.math.pow

class Lab2 : AppCompatActivity() {
    lateinit var bdCl : ActivityLab2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bdCl = ActivityLab2Binding.inflate(layoutInflater)
        setContentView(bdCl.root)
        bdCl.imageView.visibility = View.VISIBLE
    }

    fun OnClickReturnToMenu(view: View) {
        //val intent = Intent(this, MainActivity::class.java)
        //startActivity(intent)
        finish()
    }
    fun OnClickSolveL2(view: View) {
        var x = 0.0
        var n = 0
        var res = 0.0
        val input = bdCl.dataInput.editableText.toString()
        Log.i("MyLog", input)
        var data = input.split(" ")
            .toMutableList() //запись в список данных из textinputview с разделителем " "
        if (data.size == 2 && data.first().isDigitsOnly() && data.last().isDigitsOnly()) {
            Log.i("MyLog", input + "Удовлетворяет условию (числа)")
            x = data.first().toDouble()
            n = data.last().toInt()
            var i = 1.0
            while (i <= n) {
                res += x / (4.0.pow(i) + 5.0.pow(i + 2.0))
                i++
            }
            bdCl.textView.text=res.toString()
            bdCl.imageView.visibility = View.INVISIBLE
        }
        else {
            bdCl.textView.text="Ошибка. Проверьте введенные данные и исправьте их"
            bdCl.imageView.visibility = View.VISIBLE
        }

    }
}