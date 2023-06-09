package com.example.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.labs.databinding.ActivityLab3Binding

class Lab3 : AppCompatActivity() {
    lateinit var bdCl : ActivityLab3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bdCl = ActivityLab3Binding.inflate(layoutInflater)
        setContentView(bdCl.root)
    }

    fun OnClickSolveL3(view: View) {
        var input1 = bdCl.str1Input.editableText.toString()
        var input2 = bdCl.str2Input.editableText.toString()

        if (input1.isNotEmpty() && input2.isNotEmpty()) //проверка пустых строк
        {
            bdCl.textView3.text = input1 + input2 //сложение строк
        }
        else
            bdCl.textView3.text = "Ошибка. Проверьте правильность введенных данных"
    }
    fun OnClickReturnToMenu(view: View) {
        //var intent = Intent(this, MainActivity::class.java)
        //startActivity(intent)
        finish()
    }

}